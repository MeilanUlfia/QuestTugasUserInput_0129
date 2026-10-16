package com.example.tugas4.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.*
import com.example.tugas4.R

@Composable
fun ExperienceDropdown(
    selected: String,
    onSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val options = stringArrayResource(R.array.experience_options)

    Box(modifier = modifier) {
        FormTextField(
            value = selected,
            onValueChange = {},
            label = R.string.hint_experience,
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_dropdown),
                    contentDescription = stringResource(R.string.cd_open_dropdown),
                    tint = colorResource(R.color.brown_dark)
                )
            }
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(formFieldShape())
                .clickable { expanded = true }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}