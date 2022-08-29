package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.trevorwiebe.clothesline.R
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.uimodel.AddClothesUiModel
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ClothesList(
    clothesUiModel: AddClothesUiModel,
    onCheckedChange: () -> Unit
) {
    val spacing = LocalSpacing.current
    Row(modifier = Modifier
        .padding(top = spacing.spaceExtraSmall, bottom = spacing.spaceExtraSmall)
        .border(
            width = 2.dp,
            color = if(clothesUiModel.isChecked) MaterialTheme.colors.secondary
                    else MaterialTheme.colors.primaryVariant,
            shape = RoundedCornerShape(spacing.radius_two)
        )
        .fillMaxWidth()
        .clip(RoundedCornerShape(spacing.radius_two))
        .clickable { onCheckedChange() }
        .padding(spacing.spaceSmall)
    ) {
        Image(
            painter = rememberImagePainter(
                data = clothesUiModel.clothesModel.imageUrl,
                builder = {
                    crossfade(true)
                    error(R.drawable.generic_placeholder)
                    fallback(R.drawable.generic_placeholder)
                },
            ),
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(spacing.radius_two)),
            contentDescription = clothesUiModel.clothesModel.name)
        Text(
            modifier = Modifier.padding(start = spacing.spaceSmall, end = spacing.spaceSmall),
            text = clothesUiModel.clothesModel.name,
            fontWeight = if (clothesUiModel.isChecked) FontWeight.Bold else FontWeight.Normal,
            color = if(clothesUiModel.isChecked) MaterialTheme.colors.secondary
                    else MaterialTheme.colors.onBackground
        )
    }
}