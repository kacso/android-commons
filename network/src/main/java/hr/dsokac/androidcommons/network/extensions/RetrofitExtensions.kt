package hr.dsokac.androidcommons.network.extensions

import retrofit2.Response

/**
 * Read value of header with key set to [header] from [Response]
 *
 * @param header String representing header name
 *
 * @return Header value or null if header is not set
 */
fun <T> Response<T>.getHeader(header: String): String? {
    return headers().get(header)
}