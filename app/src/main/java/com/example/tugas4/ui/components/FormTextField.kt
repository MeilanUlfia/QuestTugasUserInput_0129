package com.example.tugas4.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import com.example.tugas4.R

@Composable
fun formFieldShape() = RoundedCornerShape(dimensionResource(R.dimen.field_corner))

@Composable
fun FormTextField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    isError: Boolean = false,
    @StringRes errorMessage: Int? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        readOnly = readOnly,
        singleLine = true,
        isError = isError,
        label = { Text(stringResource(label)) },
        supportingText = if (isError && errorMessage != null) {
            { Text(stringResource(errorMessage)) }
        } else null,
        trailingIcon = trailingIcon,
        keyboardOptions = keyboardOptions,
        shape = formFieldShape(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(R.color.primary_blue),
            unfocusedBorderColor = colorResource(R.color.brown_dark),
            errorBorderColor = colorResource(R.color.error_red),
            focusedLabelColor = colorResource(R.color.primary_blue),
            unfocusedLabelColor = colorResource(R.color.gray_hint),
            cursorColor = colorResource(R.color.primary_blue)
        )
    )
}