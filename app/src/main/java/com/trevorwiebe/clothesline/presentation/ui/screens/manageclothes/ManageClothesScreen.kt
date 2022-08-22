package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.trevorwiebe.clothesline.presentation.ui.components.CustomFloatingActionButton
import com.trevorwiebe.clothesline.presentation.ui.components.allTextToCaps
import com.trevorwiebe.clothesline.presentation.ui.components.parseLongToCurrency
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.components.ClothesCategoryBubble
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.components.ClothesList
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.components.ClothesWorthPane
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ManageClothesScreen(
    onNavigateToAddClothes: (Int) -> Unit,
    viewModel: ManageClothesViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current

    Scaffold(
        topBar = {},
        floatingActionButton = {
            CustomFloatingActionButton(
                icon = Icons.Default.Add,
                onClick = { onNavigateToAddClothes(viewModel.state.selectedClothesCategory.primaryKey!!) },
                contentDescription = viewModel.state.selectedClothesCategory.name,
                text = allTextToCaps(text = viewModel.state.selectedClothesCategory.name)
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
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                LazyColumn {
                    item{
                        ClothesWorthPane(
                            clothesCategoryModel = viewModel.state.selectedClothesCategory,
                            totalAmount = parseLongToCurrency(amount = viewModel.state.clothesWorth)
                        )
                        Spacer(modifier = Modifier.height(spacing.spaceSmall))
                    }
                    items(viewModel.state.clothesList){ clothesModel ->
                        Divider(color = MaterialTheme.colors.primaryVariant, thickness = 1.dp)
                        ClothesList(clothesModel = clothesModel)
                    }
                }
            }
        }
    )
}