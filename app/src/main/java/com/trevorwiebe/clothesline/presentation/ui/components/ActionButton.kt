package com.trevorwiebe.clothesline.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(spacing.radius_two))
            .clickable { onClick() }
            .fillMaxWidth()
            .background(color)
            .padding(top = spacing.spaceMediumLarge, bottom = spacing.spaceMediumLarge),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = allTextToCaps(text = text),
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onPrimary
        )
    }

}