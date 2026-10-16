package com.example.tugas4.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.*
import com.example.tugas4.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthDateField(
    value: String,
    onDateSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var showDialog by rememberSaveable { mutableStateOf(false) }

    Box(modifier = modifier) {
        FormTextField(
            value = value,
            onValueChange = {},
            label = R.string.hint_birth_date,
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_calendar),
                    contentDescription = stringResource(R.string.cd_pick_date),
                    tint = colorResource(R.color.brown_dark)
                )
            }
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(formFieldShape())
                .clickable { showDialog = true }
        )
    }

    if (showDialog) {
        val pickerState = rememberDatePickerState(
            selectableDates = object : SelectableDates {
                override fun isSelectableDate(utcTimeMillis: Long): Boolean =
                    utcTimeMillis <= System.currentTimeMillis()
            }
        )
        val pattern = stringResource(R.string.date_pattern)
        val utcId = stringResource(R.string.timezone_utc)

        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(
                    enabled = pickerState.selectedDateMillis != null,
                    onClick = {
                        pickerState.selectedDateMillis?.let { millis ->
                            val formatter = SimpleDateFormat(pattern, Locale.getDefault())
                                .apply { timeZone = TimeZone.getTimeZone(utcId) }
                            onDateSelected(formatter.format(Date(millis)))
                        }
                        showDialog = false
                    }
                ) { Text(stringResource(R.string.dialog_ok)) }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(stringResource(R.string.dialog_cancel))
                }
            }
        ) {
            DatePicker(state = pickerState)
        }
    }
}