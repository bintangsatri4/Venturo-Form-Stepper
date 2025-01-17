package com.venturo.formstepper.ui.components.inputs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String = "",
    isError: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    errorMessage: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    Column {
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(),
            value = value,
            onValueChange = { onValueChange(it) },
            isError = errorMessage != null,
            placeholder = {
                placeholder?.let {
                    Text(text = it)
                }
            },
            label = {
                label?.let {
                    Text(text = it)
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
            )
        )
        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
            )
        }
    }
}