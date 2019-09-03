package com.github.kacso.androidcommons.extensions

import java.util.regex.Pattern

/**
 *
 * Extension class for String based classes
 *
 * @author Danijel Sokač
 */


/**
 * This function will check if any of input key values matches any words in query parameter.
 * Function is case insensitive.
 *
 * @example
 *      keys: listOf("John", "Doe")
 *      query: "John Doe"        query: "Mark doe"       query: "Mark"
 *      result: true            result: true        result: false
 *
 * @param this      list of keys to be searched on
 * @param query     query on which search should be performed
 * @param ignoreCase `true` to ignore character case when comparing strings. By default `true`.
 * @return true if query matches any of keys, false otherwise
 */
fun List<String?>.matches(query: String?, ignoreCase: Boolean = true): Boolean {
    //If there is no keys to search on, then there is no query that will match those keys
    if (this.isEmpty()) return false

    //If query is empty, then function should return true
    if (query.isNullOrEmpty()) return true

    //Trim whitespaces and split by space character in order to query on per word bases
    val queryList = query.trim().split(" ")

    //Iterate trough all query words
    queryList.forEach { q ->
        var matches = false
        //Check for each key if word matches at least one of the keys
        this.takeWhile { !matches }
            .forEach {
                if (it?.contains(q, ignoreCase) == true) {
                    matches = true
                }
            }
        if (!matches) {
            return false
        }
    }

    return true
}

/**
 * Verifies if provided string is in valid email format.
 *
 * @return true if string is properly formatted, false otherwise
 */
fun String.isEmail(): Boolean {
    val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}