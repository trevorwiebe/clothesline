package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.trevorwiebe.clothesline.presentation.navigation.Route
import com.trevorwiebe.clothesline.presentation.ui.components.CustomFloatingActionButton
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.components.ClothesCategoryBubble
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ManageClothesScreen(
    navController: NavHostController,
    viewModel: ManageClothesViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current

    Scaffold(
        topBar = {},
        floatingActionButton = {
            CustomFloatingActionButton(
                icon = Icons.Default.Add,
                onClick = { navController.navigate(Route.ADD_CLOTHES) },
                contentDescription = viewModel.state.selectedClothesCategory.name,
                text = viewModel.state.selectedClothesCategory.name
            )
        },
        content = {
            Column(modifier = Modifier.padding(spacing.spaceMedium)) {
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                LazyRow(){
                    items(viewModel.state.clothesCategoryList){ clothesCategoryModel ->
                        ClothesCategoryBubble(
                            isSelected = viewModel.state.selectedClothesCategory == clothesCategoryModel,
                            name = clothesCategoryModel.name,
                            onClick = {viewModel.onEvent(ManageClothesEvent.OnClothesCategorySelected(clothesCategoryModel))}
                        )
                        Spacer(modifier = Modifier.width(spacing.spaceMedium))
                    }
                }
            }
        }
    )
}