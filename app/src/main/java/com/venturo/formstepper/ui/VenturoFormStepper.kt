package com.venturo.formstepper.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.venturo.formstepper.screen.register.RegisterScreen
import com.venturo.formstepper.ui.navigation.Screen

@Composable
fun VenturoFormStepper(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Register.route
    ) {
        composable(Screen.Register.route) {
            RegisterScreen(navController = navController)
        }
    }
}