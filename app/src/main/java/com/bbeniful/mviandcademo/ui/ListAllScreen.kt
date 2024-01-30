package com.bbeniful.mviandcademo.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ListAllScreen() {
    val viewModel = hiltViewModel<ListAllViewModel>()
}

@Composable
fun ListAllScreenContent() {

}
