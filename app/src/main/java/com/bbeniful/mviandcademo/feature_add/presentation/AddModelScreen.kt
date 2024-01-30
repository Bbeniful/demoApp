package com.bbeniful.mviandcademo.feature_add.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.bbeniful.mviandcademo.DemoModel
import com.bbeniful.mviandcademo.core.domain.extensions.popBackstackIfCan

@Composable
fun AddModelScreen(navController: NavController) {
    val viewModel = hiltViewModel<AddModelViewModel>()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    AddModelScreenContent(uiState = uiState.value,
        onName = { viewModel.setEvent(AddUIState.Event.SetName(it)) },
        onLanguage = { viewModel.setEvent(AddUIState.Event.SetLanguage(it)) },
        onLevel = { viewModel.setEvent(AddUIState.Event.SetLevel(it)) },
        onSave = {
            viewModel.setEvent(AddUIState.Event.Save)
            navController.popBackstackIfCan()
        })
}

@Composable
fun AddModelScreenContent(
    uiState: AddUIState.UIState,
    onName: (String) -> Unit,
    onLanguage: (String) -> Unit,
    onLevel: (String) -> Unit,
    onSave: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            TextField(
                value = uiState.name,
                onValueChange = onName,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                singleLine = true
            )
            TextField(
                value = uiState.language,
                onValueChange = onLanguage,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                singleLine = true
            )
            TextField(
                value = uiState.level,
                onValueChange = onLevel,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
                )
            )
            Button(onClick = {
                onSave()
            }) {
                Text(text = "Save")
            }
        }
    }
}