package com.github.kacso.androidcommons.core.dialogs

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import com.github.kacso.androidcommons.core.Result
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime


/**
 * Dialog class which combines DatePickerDialog and TimePickerDialog in one logic sequence
 *
 * @property context           Context on which dialog is to be shown
 * @property initialDateTime   Date & time to be preselected
 * @property listener          Listener on which result will be returned
 *
 * @author Danijel Sokač
 */
class DateTimePickerDialog(
    private val context: Context,
    private val initialDateTime: LocalDateTime = LocalDateTime.now(),
    private val listener: Result<LocalDateTime>
) {

    private var selectedDate: LocalDate? = null

    /**
     * Function to be called in order to display dialog to the user
     */
    fun show() {
        DatePickerDialog(context,
            DatePickerDialog.OnDateSetListener { _, year, month, day ->
                selectedDate = LocalDate.of(year, month, day)
                showTimePicker()
            }
            ,
            initialDateTime.year,
            initialDateTime.monthValue,
            initialDateTime.dayOfMonth
        ).show()
    }

    private fun showTimePicker() {
        TimePickerDialog(context,
            TimePickerDialog.OnTimeSetListener { _, hour, min ->

                listener.invoke(
                    LocalDateTime.of(selectedDate, LocalTime.of(hour, min))
                )
            }
            , initialDateTime.hour, initialDateTime.minute, true
        ).show()
    }
}
