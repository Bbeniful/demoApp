package com.bbeniful.mviandcademo.feature_add.presentation

import com.bbeniful.mviandcademo.DemoModel

class AddUIState {

    data class UIState(
        val id: Int = 0,
        val name: String = "",
        val language: String = "",
        val level: String = "0"
    )

    sealed class Event {
        class SetName(val name: String) : Event()
        class SetLanguage(val language: String) : Event()
        class SetLevel(val level: String) : Event()
        data object Save : Event()
    }
}