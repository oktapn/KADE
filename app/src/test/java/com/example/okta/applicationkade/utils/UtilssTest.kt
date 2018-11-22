package com.example.okta.applicationkade.utils

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat

class UtilssTest {

    @Test
    fun toSimpleString() {
        val util = Utilss()
        val dateFormat = SimpleDateFormat("MM/dd/yyyy")
        val date = dateFormat.parse("02/28/2018")
        assertEquals("Wed, 28 Feb 2018", util.toSimpleString(date))
    }
}