package com.trevorwiebe.clothesline.presentation.ui.components

import androidx.compose.runtime.Composable

@Composable
@Deprecated(message = "use parse long to currency use case")
fun parseLongToCurrency(
    amount: String
): Long {
    val formattedAmount = amount.replace("""[$,.]""".toRegex(), "")
    return formattedAmount.toLong()
}