package com.github.kacso.androidcommons.security.repository

import com.github.kacso.androidcommons.network.exceptions.BadRequest
import com.github.kacso.androidcommons.network.exceptions.Unauthorized
import com.github.kacso.androidcommons.preferences.ISharedPrefs
import com.github.kacso.androidcommons.security.ACCESS_TOKEN_PREFS_KEY
import com.github.kacso.androidcommons.security.REFRESH_TOKEN_PREFS_KEY
import com.github.kacso.androidcommons.security.TOKEN_TYPE_PREFS_KEY
import com.github.kacso.androidcommons.security.USERNAME_PREFS_KEY
import com.github.kacso.androidcommons.security.network.models.OAuth2LoginResponse
import com.github.kacso.androidcommons.security.network.services.RxOAuth2Service
import com.github.kacso.androidcommons.security.repositories.impl.RxOAuth2Repository
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Single
import okhttp3.ResponseBody
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RxOAuth2RepositoryTest {
    private val ACCESS_TOKEN = "AccessToken"
    private val REFRESH_TOKEN = "RefreshToken"
    private val TOKEN_TYPE = "TokenType"
    private val USERNAME = "Username"
    private val PASSWORD = "Password"
    private val AUTHORIZATION_KEY = "MockedAuthorizationKey"

    @Mock
    lateinit var sharedPrefs: ISharedPrefs
    @Mock
    lateinit var oAuth2Service: RxOAuth2Service

    lateinit var authRepository: RxOAuth2Repository


    @BeforeEach
    fun setupTests() {
        MockitoAnnotations.initMocks(this)
        authRepository = RxOAuth2Repository(
            sharedPrefs,
            oAuth2Service,
            AUTHORIZATION_KEY
        )
    }

    @Test
    fun readEmptyAccessToken() {
        Mockito.`when`(sharedPrefs.read(ACCESS_TOKEN_PREFS_KEY, null as String?)).doAnswer {
            it.getArgument(1)
        }

        val token = authRepository.getAccessToken()
        Assertions.assertNull(token)
    }

    @Test
    fun readAccessToken() {
        Mockito.`when`(sharedPrefs.read(ACCESS_TOKEN_PREFS_KEY, null as String?)).thenReturn(ACCESS_TOKEN)

        val token = authRepository.getAccessToken()
        Assertions.assertEquals(ACCESS_TOKEN, token)
    }

    @Test
    fun readEmptyRefreshToken() {
        Mockito.`when`(sharedPrefs.read(REFRESH_TOKEN_PREFS_KEY, null as String?)).doAnswer {
            it.getArgument(1)
        }

        val token = authRepository.getRefreshToken()
        Assertions.assertNull(token)
    }

    @Test
    fun readRefreshToken() {
        Mockito.`when`(sharedPrefs.read(REFRESH_TOKEN_PREFS_KEY, null as String?)).thenReturn(REFRESH_TOKEN)

        val token = authRepository.getRefreshToken()
        Assertions.assertEquals(REFRESH_TOKEN, token)
    }

    @Test
    fun readEmptyTokenType() {
        Mockito.`when`(sharedPrefs.read(TOKEN_TYPE_PREFS_KEY, null as String?)).doAnswer {
            it.getArgument(1)
        }

        val type = authRepository.getTokenType()
        Assertions.assertNull(type)
    }

    @Test
    fun readTokenType() {
        Mockito.`when`(sharedPrefs.read(TOKEN_TYPE_PREFS_KEY, null as String?)).thenReturn(TOKEN_TYPE)

        val type = authRepository.getTokenType()
        Assertions.assertEquals(TOKEN_TYPE, type)
    }

    @Test
    fun saveTokens() {
        authRepository.save(ACCESS_TOKEN, REFRESH_TOKEN, TOKEN_TYPE)

        verify(sharedPrefs, times(1)).write(ACCESS_TOKEN_PREFS_KEY, ACCESS_TOKEN)
        verify(sharedPrefs, times(1)).write(REFRESH_TOKEN_PREFS_KEY, REFRESH_TOKEN)
        verify(sharedPrefs, times(1)).write(TOKEN_TYPE_PREFS_KEY, TOKEN_TYPE)
    }

    @Test
    fun saveUsername() {
        authRepository.saveUsername(USERNAME)

        verify(sharedPrefs, times(1)).write(USERNAME_PREFS_KEY, USERNAME)
    }

    @Test
    fun clearSession() {
        authRepository.clearSession()

        verify(sharedPrefs, times(1)).removeKey(ACCESS_TOKEN_PREFS_KEY)
        verify(sharedPrefs, times(1)).removeKey(REFRESH_TOKEN_PREFS_KEY)
        verify(sharedPrefs, times(1)).removeKey(TOKEN_TYPE_PREFS_KEY)
        verify(sharedPrefs, times(1)).removeKey(USERNAME_PREFS_KEY)
    }

    @Test
    fun readEmptyUsername() {
        Mockito.`when`(sharedPrefs.read(USERNAME_PREFS_KEY, null as String?)).doAnswer {
            it.getArgument(1)
        }

        val username = authRepository.getUsername()
        Assertions.assertNull(username)
    }

    @Test
    fun readUsername() {
        Mockito.`when`(sharedPrefs.read(USERNAME_PREFS_KEY, null as String?)).thenReturn(USERNAME)

        val username = authRepository.getUsername()
        Assertions.assertEquals(USERNAME, username)
    }

    @Test
    fun successfulLogin() {
        Mockito.`when`(
            oAuth2Service.login(
                username = USERNAME,
                password = PASSWORD,
                authorizationKey = AUTHORIZATION_KEY
            )
        )
            .thenReturn(
                Single.just(
                    OAuth2LoginResponse(
                        accessToken = ACCESS_TOKEN,
                        refreshToken = REFRESH_TOKEN,
                        expiresIn = 1000,
                        tokenType = TOKEN_TYPE
                    )
                )
            )

        authRepository.login(USERNAME, PASSWORD).blockingAwait()

        verify(sharedPrefs, times(1)).write(ACCESS_TOKEN_PREFS_KEY, ACCESS_TOKEN)
        verify(sharedPrefs, times(1)).write(REFRESH_TOKEN_PREFS_KEY, REFRESH_TOKEN)
        verify(sharedPrefs, times(1)).write(TOKEN_TYPE_PREFS_KEY, TOKEN_TYPE)
        verify(sharedPrefs, times(1)).write(USERNAME_PREFS_KEY, USERNAME)
    }

    @Test
    fun unsuccessfulLogin() {
        Mockito.`when`(
            oAuth2Service.login(
                username = USERNAME,
                password = PASSWORD,
                authorizationKey = AUTHORIZATION_KEY
            )
        )
            .thenReturn(
                Single.error(Unauthorized())
            )

        val throwable = authRepository.login(USERNAME, PASSWORD).blockingGet()

        Assertions.assertEquals(Unauthorized::class.java, throwable!!.javaClass)
        verify(sharedPrefs, times(0)).write(ACCESS_TOKEN_PREFS_KEY, ACCESS_TOKEN)
        verify(sharedPrefs, times(0)).write(REFRESH_TOKEN_PREFS_KEY, REFRESH_TOKEN)
        verify(sharedPrefs, times(0)).write(TOKEN_TYPE_PREFS_KEY, TOKEN_TYPE)
        verify(sharedPrefs, times(0)).write(USERNAME_PREFS_KEY, USERNAME)
    }

    @Test
    fun successfulRefreshToken() {
        Mockito.`when`(oAuth2Service.refreshToken(refreshToken = REFRESH_TOKEN, authorizationKey = AUTHORIZATION_KEY))
            .thenReturn(
                Single.just(
                    OAuth2LoginResponse(
                        accessToken = ACCESS_TOKEN + "_",
                        refreshToken = REFRESH_TOKEN + "_",
                        expiresIn = 1000,
                        tokenType = TOKEN_TYPE + "_"
                    )
                )
            )
        Mockito.`when`(sharedPrefs.read(REFRESH_TOKEN_PREFS_KEY, null as String?)).thenReturn(REFRESH_TOKEN)

        authRepository.refreshToken().blockingAwait()

        verify(sharedPrefs, times(1)).write(ACCESS_TOKEN_PREFS_KEY, ACCESS_TOKEN + "_")
        verify(sharedPrefs, times(1)).write(REFRESH_TOKEN_PREFS_KEY, REFRESH_TOKEN + "_")
        verify(sharedPrefs, times(1)).write(TOKEN_TYPE_PREFS_KEY, TOKEN_TYPE + "_")
    }

    @Test
    fun unsuccessfulRefreshToken() {
        Mockito.`when`(oAuth2Service.refreshToken(refreshToken = REFRESH_TOKEN, authorizationKey = AUTHORIZATION_KEY))
            .thenReturn(
                Single.error(Unauthorized())
            )
        Mockito.`when`(sharedPrefs.read(REFRESH_TOKEN_PREFS_KEY, null as String?)).thenReturn(REFRESH_TOKEN)

        val throwable = authRepository.refreshToken().blockingGet()

        Assertions.assertEquals(Unauthorized::class.java, throwable!!.javaClass)
        verify(sharedPrefs, times(0)).write(ACCESS_TOKEN_PREFS_KEY, ACCESS_TOKEN)
        verify(sharedPrefs, times(0)).write(REFRESH_TOKEN_PREFS_KEY, REFRESH_TOKEN)
        verify(sharedPrefs, times(0)).write(TOKEN_TYPE_PREFS_KEY, TOKEN_TYPE)
    }

    @Test
    fun successfulLogout() {
        Mockito.`when`(oAuth2Service.logout("$TOKEN_TYPE $ACCESS_TOKEN"))
            .thenReturn(
                Single.just(ResponseBody.create(null, ""))
            )
        Mockito.`when`(sharedPrefs.read(ACCESS_TOKEN_PREFS_KEY, null as String?)).thenReturn(ACCESS_TOKEN)
        Mockito.`when`(sharedPrefs.read(TOKEN_TYPE_PREFS_KEY, null as String?))
            .thenReturn(TOKEN_TYPE)

        authRepository.logout().blockingAwait()

        verify(sharedPrefs, times(1)).removeKey(ACCESS_TOKEN_PREFS_KEY)
        verify(sharedPrefs, times(1)).removeKey(REFRESH_TOKEN_PREFS_KEY)
        verify(sharedPrefs, times(1)).removeKey(TOKEN_TYPE_PREFS_KEY)
        verify(sharedPrefs, times(1)).removeKey(USERNAME_PREFS_KEY)
    }

    @Test
    fun unsuccessfulLogout() {
        Mockito.`when`(oAuth2Service.logout("$TOKEN_TYPE $ACCESS_TOKEN"))
            .thenReturn(
                Single.error(BadRequest())
            )
        Mockito.`when`(sharedPrefs.read(ACCESS_TOKEN_PREFS_KEY, null as String?)).thenReturn(ACCESS_TOKEN)
        Mockito.`when`(sharedPrefs.read(TOKEN_TYPE_PREFS_KEY, null as String?))
            .thenReturn(TOKEN_TYPE)

        val throwable = authRepository.logout().blockingGet()

        Assertions.assertEquals(BadRequest::class.java, throwable!!.javaClass)
        verify(sharedPrefs, times(0)).removeKey(ACCESS_TOKEN_PREFS_KEY)
        verify(sharedPrefs, times(0)).removeKey(REFRESH_TOKEN_PREFS_KEY)
        verify(sharedPrefs, times(0)).removeKey(TOKEN_TYPE_PREFS_KEY)
        verify(sharedPrefs, times(0)).removeKey(USERNAME_PREFS_KEY)
    }
}