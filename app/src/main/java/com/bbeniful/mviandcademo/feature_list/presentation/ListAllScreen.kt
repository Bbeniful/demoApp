package com.bbeniful.mviandcademo.feature_list.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.bbeniful.mviandcademo.DemoModel
import com.bbeniful.mviandcademo.core.domain.utilities.Routes

@Composable
fun ListAllScreen(navController: NavController) {
    val viewModel = hiltViewModel<ListAllViewModel>()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    ListAllScreenContent(uiState = uiState.value) {
        navController.navigate(Routes.Add.route)
    }
}

@Composable
fun ListAllScreenContent(uiState: ListUIState.UIState, onAdd: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(uiState.data) {
                ListItem(demoModel = it)
            }
        }
        FloatingActionButton(
            onClick = { onAdd() },
            shape = RoundedCornerShape(55.dp),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 22.dp, end = 22.dp)
        ) {
            Text(text = "Add new")
        }
    }
}

@Composable
fun ListItem(demoModel: DemoModel) {
    Column {
        Text(text = demoModel.name)
        Text(text = demoModel.language)
        Text(text = demoModel.level)
        Divider()
    }
}
