package com.example.tugas4.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import com.example.tugas4.R
import com.example.tugas4.model.HeaderSlide

@Composable
fun HeaderPager(
    pagerState: PagerState,
    slides: List<HeaderSlide>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Image(
                painter = painterResource(slides[page].image),
                contentDescription = stringResource(slides[page].description),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.scrim_header))
        )
        PagerIndicator(
            pageCount = slides.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier
                .align(Alignment.TopStart)
                .statusBarsPadding()
                .padding(dimensionResource(R.dimen.dot_padding))
        )
    }
}