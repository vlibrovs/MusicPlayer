package com.vlibrovs.musicplayer.util.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.ConstraintSetScope

@Composable
fun rememberConstraintSet(description: ConstraintSetScope.() -> Unit) = remember {
    ConstraintSet(description)
}