package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ClothesWorthPane(
    clothesCategoryModel: ClothesCategoryModel,
    totalAmount: String
) {
    val spacing = LocalSpacing.current
    Column {
        Text(
            text = "Total worth for ${clothesCategoryModel.name}"
        )
        Text(
            modifier = Modifier
                .padding(top = spacing.spaceSmall, bottom = spacing.spaceSmall),
            text = totalAmount,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
    }
}