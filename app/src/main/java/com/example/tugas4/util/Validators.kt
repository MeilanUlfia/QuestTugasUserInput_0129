package com.example.tugas4.util

import android.util.Patterns

fun String.isValidEmail(): Boolean =
    Patterns.EMAIL_ADDRESS.matcher(this.trim()).matches()