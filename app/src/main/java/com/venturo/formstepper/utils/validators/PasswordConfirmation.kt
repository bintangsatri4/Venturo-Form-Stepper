package com.venturo.formstepper.utils.validators

import me.naingaungluu.formconductor.FieldResult
import me.naingaungluu.formconductor.annotations.FieldValidation
import me.naingaungluu.formconductor.validation.rules.StateBasedValidationRule

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@FieldValidation(
    fieldType = String::class,
    validator = PasswordConfirmationRule::class,
)
annotation class PasswordConfirmation(val passwordFieldName: String)

object PasswordConfirmationRule : StateBasedValidationRule<String, PasswordConfirmation, Any> {
    override fun validate(
        value: String,
        options: PasswordConfirmation,
        formState: Any
    ): FieldResult {
        val passwordField = formState::class.members.firstOrNull { it.name == options.passwordFieldName }
            ?: return FieldResult.Error("Password field not found", this)

        val passwordValue = passwordField.call(formState) as? String
            ?: return FieldResult.Error("Password field is not a string", this)

        return if (value == passwordValue) {
            FieldResult.Success
        } else {
            FieldResult.Error("Password confirmation does not match", this)
        }
    }
}