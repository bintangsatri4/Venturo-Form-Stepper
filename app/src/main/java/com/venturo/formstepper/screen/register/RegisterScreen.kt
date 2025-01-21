package com.venturo.formstepper.screen.register

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.venturo.formstepper.ui.components.inputs.CustomTextField
import me.naingaungluu.formconductor.FieldResult
import me.naingaungluu.formconductor.FormResult
import me.naingaungluu.formconductor.composeui.field
import me.naingaungluu.formconductor.composeui.form

@Composable fun RegisterScreen(
    navController: NavController,
    modifier: Modifier = Modifier) {
    val registerRequest = RegisterForm()


    @Composable
    fun RegisterContent(
        modifier: Modifier = Modifier,
        registerRequest: RegisterForm,
        onNameUpdate: (String) -> Unit,
        onEmailUpdate: (String) -> Unit,
        onPhoneNumberUpdate: (String) -> Unit,
        onPasswordUpdate: (String) -> Unit,
        onConfirmPasswordUpdate: (String) -> Unit
    ) {
        val formState = form(RegisterForm::class) {
            field(RegisterForm::name) {
                val resultState = resultState.value
                CustomTextField(
                    modifier = modifier.fillMaxWidth(),
                    label = "Name",
                    value = registerRequest.name,
                    errorMessage = if (resultState is FieldResult.Error) resultState.message else null,
                    onValueChange = {
                        setField(it)
                        onNameUpdate(it)
                    }
                )
            }
            field(RegisterForm::email) {
                val resultState = resultState.value
                CustomTextField(
                    modifier = modifier.fillMaxWidth(),
                    label = "Email",
                    value = registerRequest.email,
                    errorMessage = if (resultState is FieldResult.Error) resultState.message else null,
                    onValueChange = {
                        setField(it)
                        onEmailUpdate(it)
                    },
                    keyboardType = KeyboardType.Email
                )
            }
            field(RegisterForm::phoneNumber) {
                val resultState = resultState.value
                CustomTextField(
                    modifier = modifier.fillMaxWidth(),
                    label = "Phone Number",
                    value = registerRequest.phoneNumber,
                    errorMessage = if (resultState is FieldResult.Error) resultState.message else null,
                    onValueChange = {
                        setField(it)
                        onPhoneNumberUpdate(it)
                    },
                    keyboardType = KeyboardType.Phone
                )
            }
            field(RegisterForm::password) {
                val resultState = resultState.value
                CustomTextField(
                    modifier = modifier.fillMaxWidth(),
                    label = "Password",
                    value = registerRequest.password,
                    errorMessage = if (resultState is FieldResult.Error) resultState.message else null,
                    onValueChange = {
                        setField(it)
                        onPasswordUpdate(it)
                    },
                    keyboardType = KeyboardType.Password
                )
            }
            field(RegisterForm::confirmPassword) {
                val resultState = resultState.value
                CustomTextField(
                    modifier = modifier.fillMaxWidth(),
                    label = "Confirm Password",
                    value = registerRequest.confirmPassword,
                    errorMessage = if (resultState is FieldResult.Error) resultState.message else null,
                    onValueChange = {
                        setField(it)
                        onConfirmPasswordUpdate(it)
                    },
                    keyboardType = KeyboardType.Password
                )
            }
        }

        Button(
            modifier = modifier.width(200.dp),
            enabled = formState.validate() is FormResult.Success<*>,
            onClick = { /* TODO: Implement submit */ }
        ) {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = "Submit Form",
                textAlign = TextAlign.Center
            )
        }
    }
}