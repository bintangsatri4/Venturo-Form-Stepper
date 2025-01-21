package com.venturo.formstepper

import android.util.Patterns

object InputValidator {
    // Validate if the input is not empty
    fun validateRequired(
        value: String? = null,
        errorMessage: String? = null,
    ): String? {
        if (value == null || value.isEmpty()) return errorMessage ?: "Mohon masukan inputan anda"
        return null
    }

    // Validate if the input matches the email format
    fun validateEmail(
        isRequired: Boolean = true,
        email: String? = null,
        errorMessage: String? = null,
    ): String? {
        if (email == null) {
            return if (isRequired) "Mohon masukan email anda" else null
        }
        val isValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if (!isValid) return errorMessage ?: "Format email tidak valid"
        return null
    }

    // Validate if the password matches the confirm password
    fun validateConfirmPassword(
        password: String? = null,
        confirmPassword: String? = null,
        errorMessage: String? = null,
    ): String? {
        if ((password == null || password.isEmpty()) || (confirmPassword == null || confirmPassword.isEmpty()))
            return "Password tidak sesuai"
        if (password != confirmPassword) return errorMessage ?: "Password tidak sesuai"
        return null
    }

    // Validate if the input matches the phone number format
    fun validatePhoneNumber(
        isRequired: Boolean = true,
        phoneNumber: String? = null,
        errorMessage: String? = null,
        minLength: Int = 12,
        maxLength: Int = 13,
    ): String? {
        if (phoneNumber == null) {
            return if (isRequired) "Mohon masukan nomor handphone anda" else null
        }
        val isValid = Patterns.PHONE.matcher(phoneNumber).matches()
        if (!isValid) return errorMessage ?: "Nomor handphone tidak valid"
        val isValidLength = phoneNumber.length in minLength..maxLength
        if (!isValidLength) return "Jumlah Nomor handphone minimal 12 dan maksimal 13 karakter"
        return null
    }
}