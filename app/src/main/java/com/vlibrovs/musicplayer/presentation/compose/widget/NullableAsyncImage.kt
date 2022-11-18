package com.vlibrovs.musicplayer.presentation.compose.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.vlibrovs.musicplayer.R

@Composable
fun NullableAsyncImage(
    modifier: Modifier = Modifier,
    url: String?,
    contentDescription: String?
) {
    Box(
        modifier = modifier.clip(MaterialTheme.shapes.medium)
    ) {
        if (url != null) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = url,
                contentDescription = contentDescription
            )
        } else {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.empty_track_image),
                contentDescription = contentDescription
            )
        }
    }
}