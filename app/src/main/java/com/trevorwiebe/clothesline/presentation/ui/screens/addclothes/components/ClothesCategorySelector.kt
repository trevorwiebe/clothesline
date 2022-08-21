package com.trevorwiebe.clothesline.presentation.ui.screens.addclothes.components

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
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ClothesCategorySelector(
    clothesCategorySelected: ClothesCategoryModel,
    onClick: () -> Unit
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(spacing.radius_two))
            .clickable { onClick() }
            .background(MaterialTheme.colors.primaryVariant)
            .fillMaxWidth()
            .padding(spacing.spaceLarge),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = clothesCategorySelected.name
        )
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "Select Clothes Category"
        )
    }
}