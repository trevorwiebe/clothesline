package com.trevorwiebe.clothesline.core.util

sealed class UiEvent {
    object Success: UiEvent()
    data class ShowSnackbar(val message: UiText): UiEvent()
    object NavigateUp: UiEvent()
}
