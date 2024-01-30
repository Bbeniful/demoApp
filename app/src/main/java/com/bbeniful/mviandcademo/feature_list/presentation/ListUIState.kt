package com.bbeniful.mviandcademo.feature_list.presentation

import androidx.compose.runtime.Stable
import com.bbeniful.mviandcademo.DemoModel

class ListUIState {
    @Stable
    data class UIState(
        val data: List<DemoModel> = listOf()
    )
}