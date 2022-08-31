package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ClothesCategoryBubble(
    isSelected: Boolean,
    name: String,
    onClick: () -> Unit
) {

    val spacing = LocalSpacing.current

    Text(
        text = name,
        modifier = Modifier
            .clip(RoundedCornerShape(spacing.radius_two))
            .background(
                if(isSelected) MaterialTheme.colors.primary
                else MaterialTheme.colors.surface
            )
            .clickable { onClick() }
            .padding(spacing.spaceMedium),
        color =
            if (isSelected) MaterialTheme.colors.onPrimary
            else MaterialTheme.colors.onSurface
    )

}