package com.example.tugas4.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import com.example.tugas4.R
import com.example.tugas4.model.Skill
import com.example.tugas4.util.spResource

@Composable
fun SkillCheckboxes(
    selected: Set<Skill>,
    onToggle: (Skill) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.label_skill),
            color = colorResource(R.color.brown_dark),
            fontSize = spResource(R.dimen.text_label),
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Skill.entries.forEach { skill ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = skill in selected,
                        onCheckedChange = { onToggle(skill) },
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(R.color.primary_blue),
                            uncheckedColor = colorResource(R.color.brown_dark)
                        )
                    )
                    Text(
                        text = stringResource(skill.label),
                        color = colorResource(R.color.brown_dark),
                        fontSize = spResource(R.dimen.text_checkbox)
                    )
                }
            }
        }
    }
}