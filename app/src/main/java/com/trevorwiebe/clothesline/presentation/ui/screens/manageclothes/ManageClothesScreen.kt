package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.trevorwiebe.clothesline.data.local.entities.ClothesCategoryEntity
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.presentation.ui.components.CustomFloatingActionButton
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.components.ClothesCategoryBubble
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ManageClothesScreen(
    viewModel: ManageClothesViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current

    Scaffold(
        topBar = {},
        floatingActionButton = {
            CustomFloatingActionButton(
                icon = Icons.Default.Add,
                backgroundColor = MaterialTheme.colors.secondary,
                onClick = { /*TODO*/ },
                contentDescription = "Add Clothes"
            )
        },
        content = {
            Column(modifier = Modifier.padding(spacing.spaceMedium)) {
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                LazyRow(){
                    items(viewModel.state.clothesCategoryList){ clothesCategoryModel ->
                        ClothesCategoryBubble(
                            isSelected = false,
                            name = clothesCategoryModel.name,
                            onClick = {}
                        )
                        Spacer(modifier = Modifier.width(spacing.spaceMedium))
                    }
                }
            }
        }
    )
}