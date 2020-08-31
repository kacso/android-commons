package com.github.kacso.androidcommons.core.dialogs

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.kacso.androidcommons.core.Action
import com.github.kacso.androidcommons.core.R
import com.github.kacso.androidcommons.extensions.setHtmlText
import kotlinx.android.synthetic.main.dialog_message.view.*

/**
 * Dialog for displaying actionable messages to user
 */
class DialogMessage : BaseDialog() {
    companion object {
        /**
         * Creates new instance of DialogMessage. Dialog is automatically dismissed when user
         * taps on any of available buttons.
         *
         * @param title         title of dialog.
         *                      If using default value, or null is set, no title will be displayed.
         * @param message       Message to be displayed. Value is required
         * @param positiveLbl    Label to be displayed as positive button.
         *                      If using default value, or null is set, button will not be displayed.
         * @param dismissLbl    Label to be displayed as negative button.
         *                      If using default value, or null is set, button will not be displayed.
         * @param dismissible   Set if dialog can be dismissed when tapped outside of view.
         * @param positiveAction Function which will be called once user taps on positiveBtn
         * @param dismissAction Function which will be called once user dismiss dialog
         *
         * @return new instance of DialogMessage
         */
        fun newInstance(
            title: String? = null,
            message: String,
            positiveLbl: String? = null,
            dismissLbl: String? = null,
            dismissible: Boolean = true,
            positiveAction: Action? = null,
            dismissAction: Action? = null
        ): DialogMessage {
            return DialogMessage().init(
                title,
                message,
                positiveLbl,
                dismissLbl,
                dismissible,
                positiveAction,
                dismissAction
            )
        }
    }

    private var titleValue: String? = null
    private lateinit var messageValue: String
    private var confirmLbl: String? = null
    private var dismissLbl: String? = null
    private var dismissible: Boolean = true
    private var positiveAction: Action? = null
    private var dismissAction: Action? = null

    private var dismissActionCalled = false

    private fun init(
        title: String?,
        message: String,
        confirmLbl: String?,
        dismissLbl: String?,
        dismissible: Boolean,
        positiveAction: Action?,
        dismissAction: Action?
    ): DialogMessage {
        this.titleValue = title
        this.messageValue = message
        this.confirmLbl = confirmLbl
        this.dismissLbl = dismissLbl
        this.dismissible = dismissible
        this.positiveAction = positiveAction
        this.dismissAction = dismissAction
        return this
    }

    override fun getLayout(): Int = R.layout.dialog_message

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        //Set background to transparent in order to make corners visible
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        if (titleValue == null) {
            rootView.title.visibility = View.GONE
        } else {
            rootView.title.text = titleValue
        }

        rootView.message.setHtmlText(messageValue)

        isCancelable = dismissible

        if (dismissLbl == null) {
            rootView.negativeBtn.visibility = View.GONE
        } else {
            rootView.negativeBtn.text = dismissLbl
            rootView.negativeBtn.setOnClickListener {
                dismissAction?.invoke() // dismiss action will be called automatically
                dismissActionCalled = true
                dismiss()
            }
        }

        if (confirmLbl == null) {
            rootView.positiveBtn.visibility = View.GONE
        } else {
            rootView.positiveBtn.text = confirmLbl
            rootView.positiveBtn.setOnClickListener {
                positiveAction?.invoke()
                dismiss()
            }
        }

        return rootView
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if (dismissible && !dismissActionCalled) {
            dismissAction?.invoke()
        }
    }

    override fun dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss()
        if (dismissible && !dismissActionCalled) {
            dismissAction?.invoke()
        }
    }
}