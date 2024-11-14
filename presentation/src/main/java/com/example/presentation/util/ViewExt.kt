package com.example.presentation.util

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.presentation.R

fun ImageView.glideImageSet(image: String) {
    Glide.with(context)
        .load(image)
        .error(R.drawable.ic_error)
        .override(width, height)
        .centerCrop()
        .into(this)
}

fun EditText.hideKeyboard(context: Context) {
    val inputMethodManager =
        context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
    clearFocus()
    inputMethodManager?.hideSoftInputFromWindow(
        windowToken,
        InputMethodManager.HIDE_NOT_ALWAYS
    )
}