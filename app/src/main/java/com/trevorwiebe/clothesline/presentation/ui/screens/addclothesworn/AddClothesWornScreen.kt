package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.components.ClothesTypeList
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun AddClothesWornScreen(
    viewModel: AddClothesWornViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current

    LazyColumn(){
        item{
            Text(
                modifier = Modifier.padding(spacing.spaceMedium),
                text = "Add new Outfit"
            )
        }
        items(viewModel.state.clothesUiModelsList){ clothesUiModel ->
            Row(modifier = Modifier
                .padding(
                    start = spacing.spaceMedium,
                    end = spacing.spaceMedium,
                    top = spacing.spaceExtraSmall,
                    bottom = spacing.spaceExtraSmall)
            ){
                ClothesTypeList(clothesUiModel = clothesUiModel)
            }
        }
    }
}