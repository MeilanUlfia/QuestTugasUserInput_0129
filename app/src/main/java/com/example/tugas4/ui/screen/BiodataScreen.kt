package com.example.tugas4.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.tugas4.R
import com.example.tugas4.model.Skill
import com.example.tugas4.model.headerSlides
import com.example.tugas4.ui.components.*
import com.example.tugas4.util.floatResource
import com.example.tugas4.util.isValidEmail
import com.example.tugas4.util.spResource
import kotlinx.coroutines.delay

@Composable
fun BiodataScreen() {
    val pagerState = rememberPagerState(pageCount = { headerSlides.size })
    val equalWeight = floatResource(R.dimen.weight_equal)
    val slideDelay = integerResource(R.integer.slide_delay_ms).toLong()

    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var birthDate by rememberSaveable { mutableStateOf("") }
    var experience by rememberSaveable { mutableStateOf("") }
    var skills by rememberSaveable { mutableStateOf(emptySet<Skill>()) }
    var showSummary by rememberSaveable { mutableStateOf(false) }

    val isFormValid = firstName.isNotBlank() &&
            lastName.isNotBlank() &&
            email.isValidEmail() &&
            birthDate.isNotEmpty() &&
            experience.isNotEmpty() &&
            skills.isNotEmpty()

    LaunchedEffect(pagerState, slideDelay) {
        while (true) {
            delay(slideDelay)
            pagerState.animateScrollToPage(
                (pagerState.currentPage + 1) % pagerState.pageCount
            )
        }
    }

    Scaffold(
        containerColor = colorResource(R.color.screen_background)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding())
                .imePadding()
        ) {
            HeaderPager(
                pagerState = pagerState,
                slides = headerSlides,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.header_height))
                    .align(Alignment.TopCenter)
            )

            val cardShape = RoundedCornerShape(dimensionResource(R.dimen.card_corner))
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(
                        top = dimensionResource(R.dimen.card_top_margin),
                        start = dimensionResource(R.dimen.card_horizontal_margin),
                        end = dimensionResource(R.dimen.card_horizontal_margin),
                        bottom = dimensionResource(R.dimen.card_bottom_margin)
                    )
                    .shadow(dimensionResource(R.dimen.card_elevation), cardShape)
                    .background(colorResource(R.color.white), cardShape)
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(R.dimen.card_padding)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.field_spacing))
                ) {
                    Text(
                        text = stringResource(R.string.form_title),
                        color = colorResource(R.color.primary_blue),
                        fontSize = spResource(R.dimen.text_title),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(R.string.form_subtitle),
                        color = colorResource(R.color.gray_hint),
                        fontSize = spResource(R.dimen.text_subtitle)
                    )

                    NameFields(
                        firstName = firstName,
                        lastName = lastName,
                        onFirstNameChange = { firstName = it },
                        onLastNameChange = { lastName = it }
                    )

                    FormTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = R.string.hint_email,
                        modifier = Modifier.fillMaxWidth(),
                        isError = email.isNotEmpty() && !email.isValidEmail(),
                        errorMessage = R.string.error_email,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.field_spacing))
                    ) {
                        BirthDateField(
                            value = birthDate,
                            onDateSelected = { birthDate = it },
                            modifier = Modifier.weight(equalWeight)
                        )
                        ExperienceDropdown(
                            selected = experience,
                            onSelected = { experience = it },
                            modifier = Modifier.weight(equalWeight)
                        )
                    }

                    SkillCheckboxes(
                        selected = skills,
                        onToggle = { skill ->
                            skills = if (skill in skills) skills - skill else skills + skill
                        }
                    )

                    ProceedButton(
                        enabled = isFormValid,
                        onClick = { showSummary = true },
                        modifier = Modifier.padding(top = dimensionResource(R.dimen.button_top_margin))
                    )
                }
            }
        }
    }

    if (showSummary) {
        SummaryDialog(
            firstName = firstName.trim(),
            lastName = lastName.trim(),
            email = email.trim(),
            birthDate = birthDate,
            experience = experience,
            skills = skills,
            onDismiss = { showSummary = false }
        )
    }
}