package com.trevorwiebe.clothesline.presentation.ui.components

import androidx.compose.runtime.Composable

@Composable
fun parseLongToCurrency(
    amount: String
): Long {
    val formattedAmount = amount.replace("""[$,.]""".toRegex(), "")
    return formattedAmount.toLong()
}