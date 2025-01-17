package com.venturo.formstepper.ui.navigation

sealed class Screen(val route: String) {
    object Register : Screen("Register")
}