package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothescategory

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothescategory.components.ClothesTypeList
import com.trevorwiebe.clothesline.presentation.ui.components.ActionButton
import com.trevorwiebe.clothesline.presentation.ui.components.CustomOutlineTextField
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddClothesTypeScreen(
    viewModel: ManageClothesCategoryViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val TAG = "AddClothesTypeScreen"
    val keyboardController = LocalSoftwareKeyboardController.current
    val state = viewModel.state
    LazyColumn(
        modifier = Modifier
            .padding(spacing.spaceMedium)
            .fillMaxSize()
    ){
        item {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                CustomOutlineTextField(
                    labelValue = "Add clothes category - Example: Pants",
                    contentValue = state.clothesTypeString,
                    onValueChange = {
                        viewModel.onEvent(ManageClothesCategoryEvent.OnClothesCategoryChange(it))
                    }
                )
                Spacer(modifier = Modifier.height(spacing.spaceLarge))
                ActionButton(
                    text = "Save clothes category",
                    onClick = {
                        viewModel.onEvent(
                            ManageClothesCategoryEvent.OnClothesCategoryAdded(
                                name = "This is a test"
                            )
                        )
                    }
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                Text(
                    text = "Current clothes categories",
                    modifier = Modifier.padding(top = spacing.spaceSmall, bottom = spacing.spaceSmall)
                )
            }
        }
        items(state.clothesTypesList){ clothesType ->
            ClothesTypeList(
                clothesCategoryModel = clothesType,
                {
                    viewModel.onEvent(ManageClothesCategoryEvent.OnClothesCategoryDelete(clothesType))
                }
            )
        }
    }
}