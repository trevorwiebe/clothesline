package com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn.components

import android.view.View
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.trevorwiebe.clothesline.presentation.ui.components.parseDate
import com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn.ViewClothesState
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun DaySelectorBar(
    state: ViewClothesState
) {

    val spacing = LocalSpacing.current

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(spacing.spaceMedium),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            modifier = Modifier
                .clip(RoundedCornerShape(spacing.radiusMedium))
                .background(MaterialTheme.colors.primaryVariant)
                .padding(spacing.spaceMedium),
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back"
        )
        Text(
            modifier = Modifier
                .clip(RoundedCornerShape(spacing.radiusMedium))
                .background(MaterialTheme.colors.primaryVariant)
                .padding(spacing.spaceMedium),
            text = parseDate(date = state.date)
        )
        Icon(
            modifier = Modifier
                .clip(RoundedCornerShape(spacing.radiusMedium))
                .background(MaterialTheme.colors.primaryVariant)
                .padding(spacing.spaceMedium),
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Forward"
        )
    }
}