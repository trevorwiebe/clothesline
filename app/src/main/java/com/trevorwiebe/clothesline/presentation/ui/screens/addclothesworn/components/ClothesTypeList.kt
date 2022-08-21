package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ClothesTypeList(
    name: String
) {

    val spacing = LocalSpacing.current

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(spacing.radius_two))
            .background(MaterialTheme.colors.primaryVariant)
            .padding(spacing.spaceMedium)
            .fillMaxWidth()
    ) {
        Text(
            text = name
        )
    }

}