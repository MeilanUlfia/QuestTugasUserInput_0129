package com.example.tugas4.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import com.example.tugas4.R
import com.example.tugas4.util.floatResource

@Composable
fun NameFields(
    firstName: String,
    lastName: String,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val equalWeight = floatResource(R.dimen.weight_equal)
    val nameKeyboard = KeyboardOptions(
        capitalization = KeyboardCapitalization.Words,
        imeAction = ImeAction.Next
    )
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.field_spacing))
    ) {
        FormTextField(
            value = firstName,
            onValueChange = onFirstNameChange,
            label = R.string.hint_first_name,
            modifier = Modifier.weight(equalWeight),
            keyboardOptions = nameKeyboard
        )
        FormTextField(
            value = lastName,
            onValueChange = onLastNameChange,
            label = R.string.hint_last_name,
            modifier = Modifier.weight(equalWeight),
            keyboardOptions = nameKeyboard
        )
    }
}