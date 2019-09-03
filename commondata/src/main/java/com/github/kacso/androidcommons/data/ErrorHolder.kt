package com.github.kacso.androidcommons.data

import android.content.Context
import androidx.annotation.StringRes

open class ErrorHolder(
    @StringRes val errorRes: Int? = null,
    val message: String? = null,
    val cause: Throwable? = null
) {
    override fun toString(): String {
        return message ?: ""
    }

    open fun toString(context: Context): String {
        return if (errorRes != null) {
            context.getString(errorRes)
        } else {
            message ?: ""
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is ErrorHolder) return false

        if (errorRes != other.errorRes || message != other.message
            || cause != other.cause
        ) return false

        return true
    }

    override fun hashCode(): Int {
        return errorRes.hashCode() + message.hashCode() + cause.hashCode()
    }
}