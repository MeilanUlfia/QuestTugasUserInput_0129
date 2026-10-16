package com.example.tugas4.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import com.example.tugas4.R
import com.example.tugas4.model.headerSlides
import com.example.tugas4.ui.components.HeaderPager

@Composable
fun BiodataScreen() {
    val pagerState = rememberPagerState(pageCount = { headerSlides.size })

    Scaffold(
        containerColor = colorResource(R.color.screen_background)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding())
        ) {
            HeaderPager(
                pagerState = pagerState,
                slides = headerSlides,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.header_height))
                    .align(Alignment.TopCenter)
            )
        }
    }
}