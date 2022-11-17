package com.vlibrovs.musicplayer.presentation.compose.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vlibrovs.musicplayer.R

@Composable
fun PlayPauseButton(
    modifier: Modifier = Modifier.size(60.dp),
    isPaused: Boolean,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier.background(
            color = MaterialTheme.colorScheme.primary,
            shape = CircleShape
        ),
        onClick = onClick
    ) {
        if (isPaused) {
            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = stringResource(id = R.string.play),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        } else {
            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.pause),
                contentDescription = stringResource(id = R.string.pause),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}