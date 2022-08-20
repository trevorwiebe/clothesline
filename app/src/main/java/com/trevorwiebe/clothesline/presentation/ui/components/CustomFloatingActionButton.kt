package com.trevorwiebe.clothesline.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun CustomFloatingActionButton(
    icon: ImageVector,
    backgroundColor: Color,
    onClick: () -> Unit,
    contentDescription: String
) {

    val spacing = LocalSpacing.current

    IconButton(
        modifier = Modifier
            .clip(RoundedCornerShape(spacing.radius_two))
            .background(backgroundColor)
            .padding(spacing.spaceSmall),
        onClick = { onClick() },
    ){
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = MaterialTheme.colors.onSecondary
        )
    }

}