package com.trevorwiebe.clothesline.presentation.ui.screens.addclothes.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun CustomOutlineCurrencyTextField(
    labelValue: String,
    contentValue: String,
    onValueChange: (String) -> Unit,
) {
    val spacing = LocalSpacing.current
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = contentValue,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.secondary,
            unfocusedBorderColor = MaterialTheme.colors.onBackground,
            focusedLabelColor = MaterialTheme.colors.secondary,
            unfocusedLabelColor = MaterialTheme.colors.onBackground,
            cursorColor = MaterialTheme.colors.onBackground
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        ),
        shape = RoundedCornerShape(spacing.radius_two),
        onValueChange = onValueChange,
        label = { Text(text = labelValue) }
    )
}