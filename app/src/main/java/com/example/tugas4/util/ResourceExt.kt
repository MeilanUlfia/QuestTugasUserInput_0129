package com.example.tugas4.util

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.TextUnit
import androidx.core.content.res.ResourcesCompat

@Composable
fun spResource(@DimenRes id: Int): TextUnit =
    with(LocalDensity.current) { dimensionResource(id).toSp() }

@Composable
fun floatResource(@DimenRes id: Int): Float =
    ResourcesCompat.getFloat(LocalContext.current.resources, id)