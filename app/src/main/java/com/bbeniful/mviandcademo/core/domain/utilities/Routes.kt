package com.bbeniful.mviandcademo.core.domain.utilities

sealed class Routes(val route: String) {
    data object List : Routes("list")
    data object Add : Routes("add")
}