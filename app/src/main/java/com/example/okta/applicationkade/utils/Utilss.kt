package com.example.okta.applicationkade.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class Utilss {
    @SuppressLint("SimpleDateFormat")
    fun toSimpleString(date: Date?): String? = with(date ?: Date()) {
        SimpleDateFormat("EEE, dd MMM yyy").format(this)
    }
}