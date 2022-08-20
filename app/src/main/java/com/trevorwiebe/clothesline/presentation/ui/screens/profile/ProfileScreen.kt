package com.trevorwiebe.clothesline.presentation.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.trevorwiebe.clothesline.R
import com.trevorwiebe.clothesline.presentation.navigation.Route
import com.trevorwiebe.clothesline.presentation.ui.components.ProfileImageDisplay
import com.trevorwiebe.clothesline.presentation.ui.screens.profile.components.ProfileRow
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ProfileScreen(navController: NavHostController) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier.padding(spacing.spaceMedium)
    ) {
        ProfileImageDisplay(
            imageContentDescription = "Test",
            imageUrl = "",
            placeHolder = R.drawable.generic_placeholder
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        ProfileRow(
            name = "Add Clothes",
            icon = Icons.Default.Add,
            color = MaterialTheme.colors.secondary,
            rowContentDescription = "Add Clothes",
            more = true,
            onClick = {navController.navigate(Route.MANAGE_CLOTHES)}
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        ProfileRow(
            name = "Add Clothes Types",
            icon = Icons.Default.Add,
            color = MaterialTheme.colors.secondary,
            rowContentDescription = "Add Clothes Types",
            more = true,
            onClick = {navController.navigate(Route.MANAGE_CLOTHES_TYPE)}
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        ProfileRow(
            name = "Settings",
            icon = Icons.Default.Settings,
            color = MaterialTheme.colors.secondary,
            rowContentDescription = "Settings",
            more = true,
            onClick = {navController.navigate(Route.SETTINGS)}
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        ProfileRow(
            name = "Sign Out",
            icon = Icons.Default.AccountBox,
            color = MaterialTheme.colors.secondary,
            rowContentDescription = "Sign Out",
            more = false,
            onClick = {}
        )
    }
}