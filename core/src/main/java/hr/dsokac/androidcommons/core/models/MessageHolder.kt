package hr.dsokac.androidcommons.core.models

import android.content.Context
import androidx.annotation.StringRes

open class MessageHolder(
    @StringRes val errorRes: Int? = null,
    val message: String? = null
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
}