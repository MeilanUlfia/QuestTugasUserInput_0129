package com.example.tugas4.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.*
import com.example.tugas4.R

@Composable
fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.dot_spacing))
    ) {
        repeat(pageCount) { index ->
            val color = if (index == currentPage) R.color.dot_active else R.color.dot_inactive
            Box(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.dot_size))
                    .clip(CircleShape)
                    .background(colorResource(color))
            )
        }
    }
}