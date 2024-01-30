package com.bbeniful.mviandcademo

sealed class Routes(val route: String) {
    data object List : Routes("list")
    data object Add : Routes("add")
}