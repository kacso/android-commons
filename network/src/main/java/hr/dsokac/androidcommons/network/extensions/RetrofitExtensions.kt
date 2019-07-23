package hr.dsokac.androidcommons.network.extensions

import okhttp3.Headers
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


/**
 * Converts [Headers] into [Map] where key is header name and value is header value
 */
fun Headers.toMap(): Map<String, String?> {
    val map = HashMap<String, String?>()

    names().forEach {
        map[it] = get(it)
    }

    return map
}