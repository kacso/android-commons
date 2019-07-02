package hr.dsokac.androidcommons.extensions

import android.os.Build
import android.text.Html
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 *
 * Extension class for TextView based classes
 *
 * @author Danijel Sokač
 */


/**
 * Displays real time text value according to LiveData parameter
 *
 * @param owner     The LifecycleOwner which controls the observer
 * @param value     String LiveData which updates current value of text view
 */
fun TextView.setLiveText(owner: LifecycleOwner, value: LiveData<String>) {
    value.observe(owner, Observer {
        this.text = it
    })
}


/**
 * Displays real time text value as HTML according to LiveData parameter
 *
 * @param owner     The LifecycleOwner which controls the observer
 * @param value     String representing HTML LiveData which updates current value of text view
 */
fun TextView.setLiveHtmlText(owner: LifecycleOwner, value: LiveData<String>) {
    value.observe(owner, Observer {
        setHtmlText(it)
    })
}

/**
 * Formats string as HTML and displays it to the user
 *
 * @param value     String with proper formatted HTML
 */
fun TextView.setHtmlText(value: String?) {
    if (value == null) {
        this.text = ""
    } else {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            this.text = Html.fromHtml(
                value,
                (Html.FROM_HTML_MODE_COMPACT or Html.FROM_HTML_SEPARATOR_LINE_BREAK_DIV or Html.FROM_HTML_OPTION_USE_CSS_COLORS)
            )
        } else {
            @Suppress("DEPRECATION")
            this.text = Html.fromHtml(value)
        }
    }
}