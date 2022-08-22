package com.trevorwiebe.clothesline.presentation.ui.screens.addclothes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.trevorwiebe.clothesline.presentation.ui.components.ActionButton
import com.trevorwiebe.clothesline.presentation.ui.components.CustomOutlineTextField
import com.trevorwiebe.clothesline.presentation.ui.components.parseLongToCurrency
import com.trevorwiebe.clothesline.presentation.ui.components.parseDate
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothes.components.ClothesCategorySelector
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothes.components.CustomOutlineCurrencyTextField
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun AddClothesScreen(
    clothesId: Int,
    onNavigateUp: () -> Unit,
    viewModel: AddClothesViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    var state = viewModel.state

    state = state.copy(
        selectedClothesCategoryId = clothesId
    )

    Column(modifier = Modifier.padding(spacing.spaceMedium)) {
        ClothesCategorySelector(
            onOpen = { viewModel.onEvent(AddClothesEvent.OnOpenClothesCategorySelector) }
        )
        CustomOutlineTextField(
            labelValue = "Name",
            contentValue = state.name,
            onValueChange = {viewModel.onEvent(AddClothesEvent.OnNameChanged(it))}
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        CustomOutlineTextField(
            labelValue = "Optional ID",
            contentValue = state.friendlyId,
            onValueChange = {viewModel.onEvent(AddClothesEvent.OnIdChanged(it))}
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        CustomOutlineTextField(
            labelValue = "Date purchased",
            contentValue = parseDate(date = state.datePurchased),
            onValueChange = {viewModel.onEvent(AddClothesEvent.OnDateChanged(it))}
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        CustomOutlineCurrencyTextField(
            labelValue = "Purchase price",
            contentValue = parseLongToCurrency(amount = state.purchasedPrice),
            onValueChange = {viewModel.onEvent(AddClothesEvent.OnPurchasePriceChanged(it))}
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        ActionButton(
            text = "Save ${viewModel.state.selectedClothesCategoryModel.name}",
            onClick = { viewModel.onEvent(AddClothesEvent.OnClothesSaved) })

    }

}