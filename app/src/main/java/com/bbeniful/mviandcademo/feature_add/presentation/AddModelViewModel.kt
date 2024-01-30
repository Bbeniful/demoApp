package com.bbeniful.mviandcademo.feature_add.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bbeniful.mviandcademo.DemoModel
import com.bbeniful.mviandcademo.feature_add.domain.useCase.AddUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddModelViewModel @Inject constructor(
    private val addUseCase: AddUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow(AddUIState.UIState())
    val uiState = _uiState.asStateFlow()

    private var _event = MutableSharedFlow<AddUIState.Event>()


    init {
        subscribeEvent()
    }

    private fun subscribeEvent() {
        viewModelScope.launch {
            _event.collectLatest {
                handleEvent(event = it)
            }
        }
    }

    private fun handleEvent(event: AddUIState.Event) {
        when (event) {
            is AddUIState.Event.Save -> {
                save()
            }

            is AddUIState.Event.SetLanguage -> {
                setLanguage(language = event.language)
            }

            is AddUIState.Event.SetLevel -> {
                setLevel(level = event.level)
            }

            is AddUIState.Event.SetName -> {
                setName(name = event.name)
            }
        }
    }

    private fun setName(name: String) {
        _uiState.update {
            it.copy(
                name = name
            )
        }

    }

    private fun setLevel(level: String) {
        _uiState.update {
            it.copy(
                level = level
            )
        }
    }

    private fun setLanguage(language: String) {
        _uiState.update {
            it.copy(language = language)
        }
    }

    private fun save() {
        val demoModel = DemoModel(
            name = _uiState.value.name,
            language = _uiState.value.language,
            level = _uiState.value.level
        )
        viewModelScope.launch(Dispatchers.IO) {
            addUseCase(demoModel = demoModel)
        }
    }

    fun setEvent(event: AddUIState.Event) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }

}