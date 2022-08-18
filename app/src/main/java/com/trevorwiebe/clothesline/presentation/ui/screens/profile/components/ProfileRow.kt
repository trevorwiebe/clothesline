package com.trevorwiebe.clothesline.presentation.ui.screens.profile.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ProfileRow(
    name: String,
    icon: ImageVector,
    color: Color,
    rowContentDescription: String,
    more: Boolean
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(spacing.radiusMedium))
            .fillMaxWidth()
            .background(MaterialTheme.colors.primaryVariant)
            .padding(spacing.spaceMedium),
    ) {
        Icon(
            modifier = Modifier
                .clip(RoundedCornerShape(spacing.radiusMedium))
                .background(color)
                .padding(spacing.spaceSmall),
            imageVector = icon,
            tint = MaterialTheme.colors.onSecondary,
            contentDescription = rowContentDescription
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {  },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                modifier = Modifier
                    .padding(start = spacing.spaceMedium, end = spacing.spaceMedium),
                text = name,
                fontSize = 16.sp,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold,
            )
            if(more){
                Icon(
                    modifier = Modifier.padding(spacing.spaceSmall),
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "more"
                )
            }
        }
    }
}