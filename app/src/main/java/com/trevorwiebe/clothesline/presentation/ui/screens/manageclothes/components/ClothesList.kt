package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.trevorwiebe.clothesline.R
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.presentation.ui.components.parseCurrency
import com.trevorwiebe.clothesline.presentation.ui.components.parseDate
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ClothesList(
    clothesModel: ClothesModel
) {
    val spacing = LocalSpacing.current
    Row(modifier = Modifier
        .clip(RoundedCornerShape(spacing.radius_two))
        .clickable {  }
        .padding(top = spacing.spaceSmall, bottom = spacing.spaceSmall)
    ) {
        Image(
            painter = rememberImagePainter(
                data = clothesModel.imageUrl,
                builder = {
                    crossfade(true)
                    error(R.drawable.generic_placeholder)
                    fallback(R.drawable.generic_placeholder)
                }
            ),
            contentDescription = clothesModel.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(spacing.radius_two))
        )
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = clothesModel.name,
                    color = MaterialTheme.colors.onSecondary,
                    fontSize = 20.sp,
                    fontWeight = Bold,
                    modifier = Modifier
                        .padding(start = spacing.spaceMedium, end = spacing.spaceMedium)
                        .clip(RoundedCornerShape(spacing.radius_two))
                        .background(MaterialTheme.colors.secondary)
                        .padding(start = spacing.spaceMedium, end = spacing.spaceMedium, top = spacing.spaceSmall, bottom = spacing.spaceSmall)
                )
            }
            Column() {
                Text(
                    text = clothesModel.friendlyId,
                    modifier = Modifier.padding(start = spacing.spaceSmall, end = spacing.spaceSmall, bottom = spacing.spaceExtraSmall)
                )
                Text(
                    text = parseCurrency(amount = clothesModel.cost),
                    modifier = Modifier.padding(start = spacing.spaceSmall, end = spacing.spaceSmall, top = spacing.spaceExtraSmall, bottom = spacing.spaceExtraSmall)
                )
                Text(
                    text = parseDate(date = clothesModel.datePurchased),
                    modifier = Modifier.padding(start = spacing.spaceSmall, end = spacing.spaceSmall, top = spacing.spaceExtraSmall)
                )
            }
        }
    }
}