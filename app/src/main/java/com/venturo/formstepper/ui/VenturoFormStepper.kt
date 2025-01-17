package com.venturo.formstepper.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.venturo.formstepper.screen.register.RegisterScreen
import com.venturo.formstepper.ui.components.inputs.CustomTextField
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



@Composable
fun RegisterContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(all = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTextField(
            label = "Name",
            onValueChange = {
                // TODO
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            label = "Email",
            onValueChange = {
                // TODO
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            label = "No HP",
            onValueChange = {
                // TODO
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            label = "Password",
            onValueChange = {
                // TODO
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            label = "Confirm Password",
            onValueChange = {
                // TODO
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            modifier = Modifier.width(200.dp),
            onClick = {
                // TODO
            }
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Submit Form"
            )
        }
    }
}