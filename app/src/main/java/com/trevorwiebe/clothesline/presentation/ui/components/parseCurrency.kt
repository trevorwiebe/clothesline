package com.trevorwiebe.clothesline.presentation.ui.components

import android.icu.text.NumberFormat.getCurrencyInstance
import android.util.Log
import androidx.compose.runtime.Composable
import java.util.*

@Composable
fun parseCurrency(
    amount: Long
): String {
    val formatter = getCurrencyInstance(Locale("en"))

//    var currencyString = amount.toString()
//
//    if (currencyString.length <= 1) currencyString = "0${currencyString}"
//
//    currencyString = StringBuilder().apply {
//        insert((currencyString.length - 2), ".")
//    }.toString()
//
//    Log.d("parseCurrency", "parseCurrency: " + currencyString)
//
    return formatter.format(amount)
}