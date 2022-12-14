package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothescategory.components

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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ClothesTypeList(
    clothesCategoryModel: ClothesCategoryModel,
    onDeleteClicked: () -> Unit
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(
                top = spacing.spaceExtraSmall,
                bottom = spacing.spaceExtraSmall
            )
            .clip(RoundedCornerShape(spacing.radius_two))
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = clothesCategoryModel.name,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .padding(start = spacing.spaceMedium, end = spacing.spaceMedium),
            )
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = MaterialTheme.colors.primary,
                modifier = Modifier
                    .clip(RoundedCornerShape(spacing.radius_two))
                    .clickable { onDeleteClicked() }
                    .padding(spacing.spaceMedium)
            )
        }

    }
}