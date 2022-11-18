package com.vlibrovs.musicplayer.presentation.compose.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Dp
import com.vlibrovs.musicplayer.presentation.compose.theme.md_theme_dark_outline
import com.vlibrovs.musicplayer.presentation.compose.theme.md_theme_dark_secondary

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PlayerBar(
    modifier: Modifier = Modifier,
    progress: Float,
    onProgressChange: (Float) -> Unit,
    colors: PlayerBarColors = PlayerBarColors(),
    circleRadius: Dp? = null,
    barHeight: Dp? = null
) {
    var width by remember { mutableStateOf(0f) }
    var circleRadiusPx by remember { mutableStateOf(0f) }
    Canvas(modifier = modifier
        .onGloballyPositioned {
            width = it.size.width.toFloat()
        }
        .pointerInteropFilter {
            val newProgress = it.x / width
            onProgressChange(
                when {
                    newProgress > 1f -> 1f
                    newProgress < 0f -> 0f
                    else -> newProgress
                }
            )
            true
        }) {
        circleRadiusPx = circleRadius?.toPx() ?: (size.height / 2)
        val barHeightPx = barHeight?.toPx() ?: (size.height / 4)
        val barWidthPx = size.width
        // Background
        drawRoundRect(
            color = colors.barBackgroundColor,
            topLeft = Offset(x = 0f, y = (size.height - barHeightPx) / 2),
            size = Size(width = barWidthPx, height = barHeightPx),
            cornerRadius = CornerRadius(x = barHeightPx, y = barHeightPx)
        )
        // Progress Fill
        drawRoundRect(
            color = colors.barProgressColor,
            topLeft = Offset(x = 0f, y = (size.height - barHeightPx) / 2),
            size = Size(width = barWidthPx * progress, height = barHeightPx),
            cornerRadius = CornerRadius(x = barHeightPx, y = barHeightPx)
        )
        // Circle
        drawCircle(
            color = colors.circleColor,
            radius = circleRadiusPx,
            center = Offset(
                x = barWidthPx * progress,
                y = size.height / 2
            )
        )
    }
}

data class PlayerBarColors(
    val barBackgroundColor: Color = md_theme_dark_outline,
    val barProgressColor: Color = md_theme_dark_secondary,
    val circleColor: Color = md_theme_dark_secondary
)