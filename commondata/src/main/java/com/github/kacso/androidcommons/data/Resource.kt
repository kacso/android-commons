package com.github.kacso.androidcommons.data

/**
 * Sealed class representing properties which each resource will have.
 * This is useful in order to transmit progress and errors through LiveData
 *
 * @param data Data object of type [T] which this class should hold
 * @param error [ErrorHolder] representing that some error happend
 */
sealed class Resource<T>(
    val data: T? = null,
    val error: ErrorHolder? = null
) {
    /**
     * Class indicating that data retrieval was successful
     */
    class Success<T>(data: T) : Resource<T>(data)

    /**
     * Class indicating that data retrieval is in progress
     */
    class Loading<T>(data: T? = null) : Resource<T>(data)

    /**
     * Class indicating that error occurred during data retrieval
     */
    class Error<T>(error: ErrorHolder, data: T? = null) : Resource<T>(data, error)

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Resource<*>) return false
        if (other.javaClass != javaClass) return false

        if (data != other.data || error != other.error) return false

        return true
    }

    override fun hashCode(): Int {
        return data.hashCode() + error.hashCode()
    }
}