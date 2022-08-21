package com.trevorwiebe.clothesline.presentation.ui.components

import androidx.compose.runtime.Composable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun parseDate(
    date: LocalDate
): String {
    return DateTimeFormatter.ofPattern("M/d/YYYY").format(date)
}