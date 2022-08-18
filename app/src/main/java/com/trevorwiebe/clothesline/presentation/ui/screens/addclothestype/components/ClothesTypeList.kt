package com.trevorwiebe.clothesline.presentation.ui.screens.addclothestype.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ClothesTypeList(
    clothesTypeModel: ClothesTypeModel
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(
                start = spacing.spaceMedium,
                end = spacing.spaceMedium,
                top = spacing.spaceSmall,
                bottom = spacing.spaceSmall
            )
            .clip(RoundedCornerShape(spacing.radiusMedium))
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primaryVariant)
                .padding(spacing.spaceSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = clothesTypeModel.name,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .alignByBaseline()
                    .padding(spacing.spaceSmall),
            )
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .alignByBaseline()
                    .padding(spacing.spaceExtraSmall)
            )
        }

    }
}