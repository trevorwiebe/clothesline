package com.trevorwiebe.clothesline.presentation.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ProfileImageDisplay(
    imageContentDescription: String,
    imageUrl: String,
    @DrawableRes placeHolder: Int
) {
    val spacing = LocalSpacing.current
    val app = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(spacing.radiusMedium))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primaryVariant),
            horizontalAlignment = CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .padding(spacing.spaceLarge)
                    .clip(RoundedCornerShape(spacing.radiusMedium)),
                painter = rememberImagePainter(
                    data = imageUrl,
                    builder = {
                        crossfade(true)
                        error(placeHolder)
                        fallback(placeHolder)
                    }
                ),
                contentDescription = imageContentDescription
            )
            Text(
                text = "Trevor Wiebe",
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(start = spacing.spaceMedium, end = spacing.spaceMedium)
                    .align(CenterHorizontally),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Text(
                text = "thisistrevor4@gmail.com",
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(top=spacing.spaceSmall, start = spacing.spaceMedium, end = spacing.spaceMedium, bottom = spacing.spaceMedium)
                    .align(CenterHorizontally),
                fontWeight = FontWeight.Light
            )
        }
    }
}