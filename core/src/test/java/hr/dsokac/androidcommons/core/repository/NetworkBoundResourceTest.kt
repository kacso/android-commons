package hr.dsokac.androidcommons.core.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import hr.dsokac.androidcommons.data.ErrorHolder
import hr.dsokac.androidcommons.data.Resource
import hr.dsokac.androidcommons.network.exceptions.RequestFailedException
import hr.dsokac.androidcommons.network.models.ApiResponse
import hr.dsokac.androidcommons.network.models.ApiSuccessResponse
import hr.dsokac.androidcommons.network.utils.ApiUtil
import hr.dsokac.androidcommons.test.extensions.InstantTaskExecutorExtension
import hr.dsokac.androidcommons.test.models.Foo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference

@ExtendWith(InstantTaskExecutorExtension::class)
class NetworkBoundResourceTest {
    private lateinit var handleSaveCallResult: (Foo) -> Unit

    private lateinit var handleShouldMatch: (Foo?) -> Boolean

    private lateinit var handleCreateCall: () -> LiveData<ApiResponse<Foo>>

    private val dbData = MutableLiveData<Foo>()

    private lateinit var networkBoundResource: NetworkBoundResource<Foo, Foo>

    private val fetchedOnce = AtomicBoolean(false)

    @BeforeEach
    fun init() {
        networkBoundResource = object : NetworkBoundResource<Foo, Foo>() {
            override fun saveCallResult(item: Foo) {
                handleSaveCallResult(item)
            }

            override fun shouldFetch(data: Foo?): Boolean {
                // since test methods don't handle repetitive fetching, call it only once
                return handleShouldMatch(data) && fetchedOnce.compareAndSet(false, true)
            }

            override fun loadFromDb(): LiveData<Foo> {
                return dbData
            }

            override fun createCall(): LiveData<ApiResponse<Foo>> {
                return handleCreateCall()
            }
        }
    }

    @Test
    fun basicFromNetwork() {
        val saved = AtomicReference<Foo>()
        handleShouldMatch = { it == null }
        val fetchedDbValue = Foo(1)
        handleSaveCallResult = { foo ->
            saved.set(foo)
            dbData.setValue(fetchedDbValue)
        }
        val networkResult = Foo(1)
        handleCreateCall = { ApiUtil.successCall(networkResult) }

        val observer = mock<Observer<Resource<Foo>>>()
        networkBoundResource.asLiveData().observeForever(observer)
        verify(observer).onChanged(Resource.Loading(null))
        reset(observer)
        dbData.value = null
        Assertions.assertEquals(networkResult, saved.get())
        verify(observer).onChanged(Resource.Success(fetchedDbValue))
    }

    @Test
    fun failureFromNetwork() {
        val saved = AtomicBoolean(false)
        handleShouldMatch = { it == null }
        handleSaveCallResult = {
            saved.set(true)
        }
        val error = RequestFailedException()
        handleCreateCall = { ApiUtil.errorCall(error) }

        val observer = mock<Observer<Resource<Foo>>>()
        networkBoundResource.asLiveData().observeForever(observer)
        verify(observer).onChanged(Resource.Loading(null))
        reset(observer)
        dbData.value = null
        Assertions.assertFalse(saved.get())
        verify(observer).onChanged(Resource.Error(ErrorHolder(cause = error), null))
        verifyNoMoreInteractions(observer)
    }

    @Test
    fun dbSuccessWithoutNetwork() {
        val saved = AtomicBoolean(false)
        handleShouldMatch = { it == null }
        handleSaveCallResult = {
            saved.set(true)
        }

        val observer = mock<Observer<Resource<Foo>>>()
        networkBoundResource.asLiveData().observeForever(observer)
        verify(observer).onChanged(Resource.Loading(null))
        reset(observer)
        val dbFoo = Foo(1)
        dbData.value = dbFoo
        verify(observer).onChanged(Resource.Success(dbFoo))
        Assertions.assertFalse(saved.get())
        val dbFoo2 = Foo(2)
        dbData.value = dbFoo2
        verify(observer).onChanged(Resource.Success(dbFoo2))
        verifyNoMoreInteractions(observer)
    }

    @Test
    fun dbSuccessWithFetchFailure() {
        val dbValue = Foo(1)
        val saved = AtomicBoolean(false)
        handleShouldMatch = { foo -> foo === dbValue }
        handleSaveCallResult = {
            saved.set(true)
        }
        val apiResponseLiveData = MutableLiveData<ApiResponse<Foo>>()
        handleCreateCall = { apiResponseLiveData }

        val observer = mock<Observer<Resource<Foo>>>()
        networkBoundResource.asLiveData().observeForever(observer)
        verify(observer).onChanged(Resource.Loading(null))
        reset(observer)

        dbData.value = dbValue
        verify(observer).onChanged(Resource.Loading(dbValue))

        val error = RequestFailedException()
        apiResponseLiveData.value = ApiResponse.create(error)
        Assertions.assertFalse(saved.get())
        verify(observer).onChanged(Resource.Error(ErrorHolder(cause = error), dbValue))

        val dbValue2 = Foo(2)
        dbData.value = dbValue2
        verify(observer).onChanged(Resource.Error(ErrorHolder(cause = error), dbValue2))
        verifyNoMoreInteractions(observer)
    }

    @Test
    fun dbSuccessWithReFetchSuccess() {
        val dbValue = Foo(1)
        val dbValue2 = Foo(2)
        val saved = AtomicReference<Foo>()
        handleShouldMatch = { foo -> foo === dbValue }
        handleSaveCallResult = { foo ->
            saved.set(foo)
            dbData.setValue(dbValue2)
        }
        val apiResponseLiveData = MutableLiveData<ApiResponse<Foo>>()
        handleCreateCall = { apiResponseLiveData }

        val observer = mock<Observer<Resource<Foo>>>()
        networkBoundResource.asLiveData().observeForever(observer)
        verify(observer).onChanged(Resource.Loading(null))
        reset(observer)

        dbData.value = dbValue
        val networkResult = Foo(1)
        verify(observer).onChanged(Resource.Loading(dbValue))
        apiResponseLiveData.value = ApiSuccessResponse(networkResult, emptyMap())
        Assertions.assertEquals(networkResult, saved.get())
        verify(observer).onChanged(Resource.Success(dbValue2))
        verifyNoMoreInteractions(observer)
    }
}