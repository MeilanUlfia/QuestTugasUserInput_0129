package com.example.tugas4.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.*
import com.example.tugas4.R
import com.example.tugas4.model.Skill

@Composable
fun SummaryDialog(
    firstName: String,
    lastName: String,
    email: String,
    birthDate: String,
    experience: String,
    skills: Set<Skill>,
    onDismiss: () -> Unit
) {
    val skillNames = Skill.entries
        .filter { it in skills }
        .map { stringResource(it.label) }
        .joinToString(stringResource(R.string.list_separator))

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = colorResource(R.color.white),
        title = { Text(stringResource(R.string.summary_title)) },
        text = {
            Text(
                stringResource(
                    R.string.summary_message,
                    firstName, lastName, email, birthDate, experience, skillNames
                )
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.dialog_ok))
            }
        }
    )
}