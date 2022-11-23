package com.vlibrovs.musicplayer.presentation.compose.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vlibrovs.musicplayer.data.model.Song

@Composable
fun MusicListItem(
    song: Song,
    isPlaying: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(modifier = Modifier
        .padding(
            if (isPlaying) PaddingValues(
                horizontal = 20.dp, vertical = 5.dp
            ) else PaddingValues(horizontal = 30.dp, vertical = 15.dp)
        )
        .fillMaxWidth()
        .run {
            if (isPlaying) background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.medium
            ).padding(10.dp) else this
        }
        .clickable(interactionSource = interactionSource, indication = null, onClick = onClick)) {
        NullableAsyncImage(
            modifier = Modifier
                .size(80.dp)
                .background(
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.secondary
                ),
            url = song.imageUrl,
            contentDescription = song.title
        )
        Spacer(modifier = Modifier.width(30.dp))
        Column(
            modifier = Modifier.height(80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = song.title,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.run { if (isPlaying) primary else onBackground })
            Text(text = song.artist,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.run { if (isPlaying) onSurfaceVariant else secondary })
        }
    }
}