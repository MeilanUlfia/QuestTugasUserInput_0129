package com.example.tugas4.model

import androidx.annotation.StringRes
import com.example.tugas4.R

enum class Skill(@StringRes val label: Int) {
    ANDROID(R.string.skill_android),
    UIUX(R.string.skill_uiux),
    WEB(R.string.skill_web)
}