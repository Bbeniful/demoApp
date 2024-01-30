package com.bbeniful.mviandcademo.feature_list.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bbeniful.mviandcademo.feature_list.domain.useCase.ListDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListAllViewModel @Inject constructor(
    private val listDataUseCase: ListDataUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow(ListUIState.UIState())
    val uiState = _uiState.asStateFlow()

    init {
        setList()
    }

    private fun setList() {
        viewModelScope.launch {
            listDataUseCase.invoke().collectLatest { list ->
                Log.e("errrka -> ","$list")
                _uiState.update { state ->
                    state.copy(data = list)
                }
            }
        }
    }
}