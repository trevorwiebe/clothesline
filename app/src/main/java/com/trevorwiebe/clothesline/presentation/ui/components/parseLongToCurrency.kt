package com.trevorwiebe.clothesline.presentation.ui.components

import android.icu.text.NumberFormat.getCurrencyInstance
import android.util.Log
import androidx.compose.runtime.Composable
import java.util.*

@Composable
fun parseLongToCurrency(
    amount: Long
): String {
    val formatter = getCurrencyInstance(Locale.getDefault())

    var currencyString = amount.toString()

    when(currencyString.length){
        0 -> {currencyString = "000"}
        1 -> { currencyString = "00${currencyString}" }
        2 -> { currencyString = "0${currencyString}"}
        else -> {}
    }

    currencyString = StringBuilder(currencyString)
        .insert(currencyString.length - 2, ".")
        .toString()

    return formatter.format(currencyString.toDouble())
}