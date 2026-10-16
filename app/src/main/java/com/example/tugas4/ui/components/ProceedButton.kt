package com.example.tugas4.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import com.example.tugas4.R
import com.example.tugas4.util.spResource

@Composable
fun ProceedButton(
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.button_height)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner)),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.primary_blue),
            contentColor = colorResource(R.color.white),
            disabledContainerColor = colorResource(R.color.gray_disabled_container),
            disabledContentColor = colorResource(R.color.white)
        )
    ) {
        Text(
            text = stringResource(R.string.btn_proceed),
            fontSize = spResource(R.dimen.text_button),
            fontWeight = FontWeight.Bold
        )
    }
}