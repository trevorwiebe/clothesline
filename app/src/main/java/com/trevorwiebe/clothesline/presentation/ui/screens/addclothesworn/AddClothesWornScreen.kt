package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.trevorwiebe.clothesline.presentation.ui.components.ActionButton
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.components.ClothesTypeList
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun AddClothesWornScreen(
    viewModel: AddClothesWornViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current

    LazyColumn(modifier = Modifier.padding(start = spacing.spaceMedium, top = spacing.spaceMedium, end = spacing.spaceMedium)){
        items(viewModel.state.addOutfitUiModelsList){ clothesUiModel ->
            Row(modifier = Modifier
                .padding(
                    top = spacing.spaceExtraSmall,
                    bottom = spacing.spaceExtraSmall)
            ){
                ClothesTypeList(
                    addOutfitUiModel = clothesUiModel,
                    onOpenCategoryClick = {
                        viewModel.onEvent(AddClothesWornEvent.OnOpenClothesCategory(clothesUiModel))
                    },
                    viewModel = viewModel
                )
            }
        }
        item{
            ActionButton(
                text = "Save New Outfit",
                onClick = { viewModel.onEvent(AddClothesWornEvent.OnSaveOutfit) },
                modifier = Modifier.padding(top = spacing.spaceExtraSmall, bottom = spacing.spaceExtraLarge)
            )
        }
    }
}