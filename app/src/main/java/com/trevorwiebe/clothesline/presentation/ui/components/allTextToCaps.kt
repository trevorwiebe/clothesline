package com.trevorwiebe.clothesline.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.toUpperCase
import java.util.*

@Composable
fun allTextToCaps(
    text: String
): String {
    return text.uppercase()
}