package com.venturo.formstepper.screen.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.venturo.formstepper.ui.theme.VenturoFormStepperTheme

    @Composable

    fun RegisterScreen(
        modifier: Modifier = Modifier,
        navController: NavController,
        viewModel: RegisterViewModel = hiltViewModel()
    ) {
        RegisterContent(modifier = modifier)
    }

    @Composable
    fun RegisterContent(modifier: Modifier = Modifier) {
        Column {
            TextField(value = "", onValueChange = {})
            Spacer(modifier = Modifier.height(16.dp))
            TextField(value = "", onValueChange = {})
        }
    }

    @Preview(showBackground = true, device = "id:pixel_5")
    @Composable
    fun RegisterPreview() {
        VenturoFormStepperTheme {
            RegisterContent()
        }
    }