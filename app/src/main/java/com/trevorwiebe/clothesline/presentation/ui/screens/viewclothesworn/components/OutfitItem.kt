package com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.domain.model.OutfitModel
import com.trevorwiebe.clothesline.presentation.ui.components.parseDate
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun OutfitItem(
    outfitModel: OutfitModel,
) {

    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(spacing.radius_two))
            .background(MaterialTheme.colors.surface)
    ) {
        Text(
            text = parseDate(date = outfitModel.date),
            modifier = Modifier.padding(spacing.spaceMedium)
        )
    }
}