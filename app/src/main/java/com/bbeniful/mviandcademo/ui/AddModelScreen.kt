package com.bbeniful.mviandcademo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bbeniful.mviandcademo.DemoModel
import com.bbeniful.mviandcademo.popBackstackIfCan

@Composable
fun AddModelScreen(navController: NavController) {
    val viewModel = hiltViewModel<AddModelViewModel>()
}

@Composable
fun AddModelScreenContent(navController: NavController, onSave: (DemoModel) -> Unit) {
    val tmpName = remember {
        mutableStateOf("")
    }
    val tmpLanguage = remember {
        mutableStateOf("")
    }
    val tmpLevel = remember {
        mutableIntStateOf(0)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            TextField(value = tmpName.value, onValueChange = { tmpName.value = it })
            TextField(value = tmpLanguage.value, onValueChange = { tmpName.value = it })
            TextField(
                value = "${tmpLevel.intValue}",
                onValueChange = { tmpLevel.intValue = Integer.parseInt(it) })
            Button(onClick = { }) {
                Text(text = "Save")
            }
        }
    }
}