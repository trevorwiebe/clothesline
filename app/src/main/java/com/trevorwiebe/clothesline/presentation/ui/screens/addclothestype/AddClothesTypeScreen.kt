package com.trevorwiebe.clothesline.presentation.ui.screens.addclothestype

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothestype.components.ClothesTypeList
import com.trevorwiebe.clothesline.presentation.ui.components.ActionButton
import com.trevorwiebe.clothesline.presentation.ui.components.CustomOutlineTextField
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddClothesTypeScreen(
    viewModel: AddClothesTypeViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val TAG = "AddClothesTypeScreen"
    val keyboardController = LocalSoftwareKeyboardController.current
    val state = viewModel.state
    LazyColumn(modifier = Modifier.fillMaxSize()){
        item {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                CustomOutlineTextField(
                    labelValue = "Add Clothes Type - Example: Pants",
                    contentValue = state.clothesTypeString,
                    onValueChange = {
                        viewModel.onEvent(AddClothesTypeEvent.OnClothesTypeChange(it))
                    }
                )
                Spacer(modifier = Modifier.height(spacing.spaceLarge))
                ActionButton(
                    modifier = Modifier.padding(start = spacing.spaceMedium, end = spacing.spaceMedium),
                    text = "Save Clothes Type",
                    onClick = {
                        viewModel.onEvent(
                            AddClothesTypeEvent.OnClothesTypeAdded(
                                name = "This is a test"
                            )
                        )
                    }
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                Text(
                    text = "Current clothes types",
                    modifier = Modifier.padding(start = spacing.spaceMedium, end = spacing.spaceMedium,top = spacing.spaceSmall, bottom = spacing.spaceSmall)
                )
            }
        }
        items(state.clothesTypesList){ clothesType ->
            ClothesTypeList(
                clothesTypeModel = clothesType,
                {
                    viewModel.onEvent(AddClothesTypeEvent.OnClothesTypeDelete(clothesType))
                }
            )
        }
    }
}