package com.commandiron.calorytrackerpl.navigation

import androidx.navigation.NavController
import com.commandiron.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate){
    this.navigate(event.route)
}