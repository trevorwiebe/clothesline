package com.trevorwiebe.clothesline.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun CustomFloatingActionButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit,
    contentDescription: String
) {

    val spacing = LocalSpacing.current

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(spacing.radius_two))
            .background(MaterialTheme.colors.secondaryVariant)
            .clickable { onClick() }
            .padding(spacing.spaceMedium),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = MaterialTheme.colors.onSecondary
        )
        Spacer(modifier = Modifier.width(spacing.spaceExtraSmall))
        Text(
            text = text,
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onSecondary
        )
    }
}