package com.venturo.formstepper.screen.register

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.venturo.formstepper.InputValidator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegisterViewModel : ViewModel() {
    private val _registerRequest = MutableStateFlow(RegisterForm())
    val registerRequest: StateFlow<RegisterForm> get() = _registerRequest

    private val _isFieldError = mutableStateOf(false)
    val isFieldError: MutableState<Boolean> get() = _isFieldError

    fun updateRegisterForm(
        name: String = _registerRequest.value.name,
        email: String = _registerRequest.value.email,
        phoneNumber: String = _registerRequest.value.phoneNumber,
        password: String = _registerRequest.value.password,
        confirmPassword: String = _registerRequest.value.confirmPassword,
    ) {
        _registerRequest.value = RegisterForm(
            name = name,
            email = email,
            phoneNumber = phoneNumber,
            password = password,
            confirmPassword = confirmPassword,
        )
        validateField()
    }

    private fun validateField() {
        val validateName = InputValidator.validateRequired(_registerRequest.value.name)
        if (validateName != null) {
            _isFieldError.value = true
            return
        }
        val validateEmail = InputValidator.validateEmail(email = _registerRequest.value.email, isRequired = true)
        if (validateEmail != null) {
            _isFieldError.value = true
            return
        }
        val validatePhoneNumber = InputValidator.validatePhoneNumber(phoneNumber = _registerRequest.value.phoneNumber, isRequired = true)
        if (validatePhoneNumber != null) {
            _isFieldError.value = true
            return
        }
        val validatePassword = InputValidator.validateRequired(value = _registerRequest.value.password)
        if (validatePassword != null) {
            _isFieldError.value = true
            return
        }
        val validateConfirmPassword = InputValidator.validateConfirmPassword(password = _registerRequest.value.password, confirmPassword = _registerRequest.value.confirmPassword)
        if (validateConfirmPassword != null) {
            _isFieldError.value = true
            return
        }
        _isFieldError.value = false
    }
}