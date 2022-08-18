package com.trevorwiebe.clothesline.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun CustomOutlineTextField(
    labelValue: String,
    contentValue: String,
    onValueChange: (String) -> Unit,
) {
    val spacing = LocalSpacing.current
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = spacing.spaceMedium, end = spacing.spaceMedium),
        value = contentValue,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.secondary,
            unfocusedBorderColor = MaterialTheme.colors.onBackground,
            focusedLabelColor = MaterialTheme.colors.secondary,
            unfocusedLabelColor = MaterialTheme.colors.onBackground
        ),
        shape = RoundedCornerShape(spacing.radiusMedium),
        onValueChange = onValueChange,
        label = { Text(text = labelValue) }
    )
}