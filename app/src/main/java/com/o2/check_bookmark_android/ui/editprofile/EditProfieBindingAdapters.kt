package com.o2.check_bookmark_android.ui.editprofile

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.o2.check_bookmark_android.R

@BindingAdapter("editBtnVisibie")
fun TextView.bindEditBtnVisibie(enable: Boolean) {
    if(enable) this.visibility = View.VISIBLE
    else this.visibility = View.GONE
}

@SuppressLint("UseCompatLoadingForDrawables")
@RequiresApi(Build.VERSION_CODES.M)
@BindingAdapter("editBtnBackgroundTextColor")
fun TextView.bindEditBtnBackground(possible: Boolean) {
    if(possible) {
        this.background = context.getDrawable(R.drawable.custom_yellow_radius16)
        this.setTextColor(context.getColor(R.color.black))
    } else {
        this.background = context.getDrawable(R.drawable.custom_backgroundwhite_radius16)
        this.setTextColor(context.getColor(R.color.gray08))
    }
}