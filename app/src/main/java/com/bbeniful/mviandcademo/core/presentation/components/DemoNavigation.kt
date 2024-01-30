package com.bbeniful.mviandcademo.core.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bbeniful.mviandcademo.core.domain.utilities.Routes
import com.bbeniful.mviandcademo.feature_add.presentation.AddModelScreen
import com.bbeniful.mviandcademo.feature_list.presentation.ListAllScreen

@Composable
fun DemoNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.List.route) {
        composable(route = Routes.List.route) {
            ListAllScreen(navController = navController)
        }
        composable(route = Routes.Add.route) {
            AddModelScreen(navController = navController)
        }
    }

}