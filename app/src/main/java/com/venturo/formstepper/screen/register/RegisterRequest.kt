package com.venturo.formstepper.screen.register

import com.venturo.formstepper.utils.validators.PasswordConfirmation
import me.naingaungluu.formconductor.annotations.EmailAddress
import me.naingaungluu.formconductor.annotations.Form
import me.naingaungluu.formconductor.annotations.MaxLength
import me.naingaungluu.formconductor.annotations.MinLength

@Form
data class RegisterForm(
    val name: String = "",
    @EmailAddress
    val email: String = "",
    @MinLength(12)
    @MaxLength(13)
    val phoneNumber: String = "",
    val password: String = "",
    @PasswordConfirmation(passwordFieldName = "password")
    val confirmPassword: String = ""
)