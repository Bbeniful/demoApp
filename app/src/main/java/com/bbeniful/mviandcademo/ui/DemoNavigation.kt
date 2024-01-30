package com.bbeniful.mviandcademo.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bbeniful.mviandcademo.Routes

@Composable
fun DemoNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.List.route ){
        composable(route = Routes.List.route){
            ListAllScreen()
        }
        composable(route = Routes.Add.route){
            AddModelScreen(navController = navController)
        }
    }

}