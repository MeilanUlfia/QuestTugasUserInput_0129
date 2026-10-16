package com.example.tugas4.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.tugas4.R

@Composable
fun Tugas4Theme(content: @Composable () -> Unit) {
    val colorScheme = lightColorScheme(
        primary = colorResource(R.color.primary_blue),
        onPrimary = colorResource(R.color.white),
        background = colorResource(R.color.screen_background),
        surface = colorResource(R.color.white),
        onSurface = colorResource(R.color.brown_dark),
        outline = colorResource(R.color.brown_dark),
        error = colorResource(R.color.error_red)
    )
    MaterialTheme(colorScheme = colorScheme, content = content)
}