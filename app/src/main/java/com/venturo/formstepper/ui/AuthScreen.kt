package com.venturo.formstepper.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.venturo.formstepper.screen.register.RegisterForm
import com.venturo.formstepper.ui.components.inputs.CustomTextField
import me.naingaungluu.formconductor.FieldResult
import me.naingaungluu.formconductor.FormResult
import me.naingaungluu.formconductor.composeui.field
import me.naingaungluu.formconductor.composeui.form
 // Ensure this import is present

@Composable
fun AuthContent(
    modifier: Modifier = Modifier,
    registrationStep: Int,
    registerForm: RegisterForm,
    onNameUpdate: (String) -> Unit,
    onEmailUpdate: (String) -> Unit,
    onPhoneNumberUpdate: (String) -> Unit,
    onPasswordUpdate: (String) -> Unit,
    onConfirmPasswordUpdate: (String) -> Unit,
    onSubmit: () -> Unit
) {

    form(RegisterForm::class) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            AuthStepper(step = registrationStep, stepCount = 3)
            Spacer(modifier = Modifier.height(16.dp))
            when (registrationStep) {
                1 -> RegisterFormTab(
                    modifier = modifier,
                    registerForm = registerForm,
                    onNameUpdate = { onNameUpdate(it) },
                    onEmailUpdate = { onEmailUpdate(it) },
                    onPhoneNumberUpdate = { onPhoneNumberUpdate(it) },
                    onPasswordUpdate = { onPasswordUpdate(it) },
                    onConfirmPasswordUpdate = { onConfirmPasswordUpdate(it) },
                    onSubmit = { onSubmit() }
                )
            }
        }
    }
}

@Composable
fun RegisterFormTab(
    modifier: Modifier,
    registerForm: RegisterForm,
    onNameUpdate: (String) -> Unit,
    onEmailUpdate: (String) -> Unit,
    onPhoneNumberUpdate: (String) -> Unit,
    onPasswordUpdate: (String) -> Unit,
    onConfirmPasswordUpdate: (String) -> Unit,
    onSubmit: () -> Unit
) {


    form(RegisterForm::class) {
        Column {
            field(RegisterForm::name) {
                val resultState = resultState.value
                CustomTextField(
                    label = "Name",
                    value = registerForm.name,
                    errorMessage = if (resultState is FieldResult.Error) resultState.message else null,
                    onValueChange = {
                        setField(it)
                        onNameUpdate(it)
                    }
                )
            }
            // Add other fields similarly
            Button(
                enabled = formState.value is FormResult.Success<*>,
                onClick = { onSubmit() }
            ) {
                Text("Submit")
            }
        }
    }
}

@Composable
fun AuthStepper(step: Int, stepCount: Int) {
    Row {
        for (i in 1..stepCount) {
            Text(
                text = if (i == step) "Step $i (Current)" else "Step $i",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}