package com.o2.check_bookmark_android.util

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.EditText
import com.o2.check_bookmark_android.R

@SuppressLint("UseCompatLoadingForDrawables")
fun EditText.customOnFocusChangeListener(context: Context) {
    this.onFocusChangeListener = View.OnFocusChangeListener { view, gainFocus ->
        //포커스가 주어졌을 때
        if (gainFocus) view.background = context.getDrawable(R.drawable.custom_backgroundwhite_radius16_line_gray06)
        else view.background = context.getDrawable(R.drawable.custom_backgroundwhite_radius16)
    }
}
