package com.o2.check_bookmark_android.base

import android.view.View
import com.o2.check_bookmark_android.R
import com.o2.check_bookmark_android.databinding.DialogGrayDefaultAlertBinding
import com.o2.check_bookmark_android.databinding.DialogRedDefaultAlertBinding
import com.o2.check_bookmark_android.databinding.DialogYellowDefaultAlertBinding


data class AlertDialogModel(
    val title : String?,
    val description : String?,
    val negativeContents : String,
    val positiveContents : String
)

class DefaultYellowAlertDialog(
    private val alertDialogModel: AlertDialogModel,
    private val clickToNegative: () -> Unit,
    private val clickToPositive: () -> Unit,
) : BaseDialog<DialogYellowDefaultAlertBinding>(layoutId = R.layout.dialog_yellow_default_alert) {

    override val layoutResourceId: Int
        get() = R.layout.dialog_yellow_default_alert

    override fun initStartView() {
        binding.model = alertDialogModel
    }

    override fun initDataBinding() = Unit

    override fun initAfterBinding() {
        if(alertDialogModel.title == null) {
            binding.alertTitle.visibility = View.GONE
        }
        if(alertDialogModel.description == null) {
            binding.alertDescription.visibility = View.GONE
        }

        binding.negativeBtn.setOnClickListener {
            clickToNegative.invoke()
            dismiss()
        }
        binding.positiveBtn.setOnClickListener {
            clickToPositive.invoke()
            dismiss()
        }
    }
}

class DefaultRedAlertDialog(
    private val alertDialogModel: AlertDialogModel,
    private val clickToNegative: () -> Unit,
    private val clickToPositive: () -> Unit,
) : BaseDialog<DialogRedDefaultAlertBinding>(layoutId = R.layout.dialog_red_default_alert) {

    override val layoutResourceId: Int
        get() = R.layout.dialog_red_default_alert

    override fun initStartView() {
        binding.model = alertDialogModel
    }

    override fun initDataBinding() = Unit

    override fun initAfterBinding() {
        binding.negativeBtn.setOnClickListener {
            clickToNegative.invoke()
            dismiss()
        }
        binding.positiveBtn.setOnClickListener {
            clickToPositive.invoke()
            dismiss()
        }
    }
}


class DefaultGrayAlertDialog(
    private val alertDialogModel: AlertDialogModel,
    private val clickToNegative: () -> Unit,
) : BaseDialog<DialogGrayDefaultAlertBinding>(layoutId = R.layout.dialog_gray_default_alert) {

    override val layoutResourceId: Int
        get() = R.layout.dialog_gray_default_alert

    override fun initStartView() {
        binding.model = alertDialogModel
    }

    override fun initDataBinding() = Unit

    override fun initAfterBinding() {
        binding.negativeBtn.setOnClickListener {
            clickToNegative.invoke()
            dismiss()
        }
    }
}