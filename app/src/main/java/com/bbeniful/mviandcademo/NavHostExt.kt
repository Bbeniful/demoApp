package com.bbeniful.mviandcademo

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController

fun NavController.popBackstackIfCan() {
    if (this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
        this.popBackStack()
    }
}