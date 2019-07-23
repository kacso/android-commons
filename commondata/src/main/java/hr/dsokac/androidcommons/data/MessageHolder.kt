package hr.dsokac.androidcommons.data

import android.content.Context
import androidx.annotation.StringRes

open class MessageHolder(
    @StringRes val messageRes: Int? = null,
    val message: String? = null
) {
    override fun toString(): String {
        return message ?: ""
    }

    open fun toString(context: Context): String {
        return if (messageRes != null) {
            context.getString(messageRes)
        } else {
            message ?: ""
        }
    }
}