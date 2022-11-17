package com.vlibrovs.musicplayer.presentation.compose.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.vlibrovs.musicplayer.presentation.compose.theme.font.Poppins

val typography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Poppins,
        fontSize = 32.sp
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Poppins,
        fontSize = 18.sp
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily.Poppins,
        fontSize = 12.sp
    )
)