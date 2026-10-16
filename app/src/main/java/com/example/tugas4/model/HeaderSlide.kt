package com.example.tugas4.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.tugas4.R

data class HeaderSlide(
    @DrawableRes val image: Int,
    @StringRes val description: Int
)

val headerSlides = listOf(
    HeaderSlide(R.drawable.img_header_snoopy, R.string.cd_header_snoopy),
    HeaderSlide(R.drawable.img_header_sea, R.string.cd_header_sea),
    HeaderSlide(R.drawable.img_header_hirono, R.string.cd_header_hirono),
    HeaderSlide(R.drawable.img_header_coklat, R.string.cd_header_coklat)
)