package com.vlibrovs.musicplayer.presentation.compose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vlibrovs.musicplayer.presentation.viewmodel.MainViewModel
import com.vlibrovs.musicplayer.R
import com.vlibrovs.musicplayer.presentation.compose.widget.NullableAsyncImage
import com.vlibrovs.musicplayer.presentation.compose.widget.PlayPauseButton
import com.vlibrovs.musicplayer.presentation.compose.widget.PlayerBar
import com.vlibrovs.musicplayer.presentation.compose.widget.PlayerBarColors
import kotlin.math.roundToInt

@Composable
fun TrackScreen(
    viewModel: MainViewModel
) {
    viewModel.playingTrack?.let { track ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, bottom = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {

                }) {
                    Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = Icons.Outlined.ArrowDropDown,
                        contentDescription = stringResource(id = R.string.collapse),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(onClick = {

                }) {
                    Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = stringResource(id = R.string.menu),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            NullableAsyncImage(
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f),
                url = track.imageUrl,
                contentDescription = track.name
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = track.name,
                        style = MaterialTheme.typography.displayLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = track.authorName,
                        style = MaterialTheme.typography.displayMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PlayerBar(
                        modifier = Modifier
                            .padding(horizontal = 30.dp)
                            .fillMaxWidth()
                            .height(20.dp),
                        progress = viewModel.playerBarProgress,
                        onProgressChange = viewModel.onPlayerBarProgressChange,
                        colors = PlayerBarColors(
                            barBackgroundColor = MaterialTheme.colorScheme.outline,
                            barProgressColor = MaterialTheme.colorScheme.secondary,
                            circleColor = MaterialTheme.colorScheme.secondary
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 30.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = formatMusicTime((track.secondsLong * viewModel.playerBarProgress).roundToInt()),
                            style = MaterialTheme.typography.displaySmall,
                            color = MaterialTheme.colorScheme.secondary,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = formatMusicTime(track.secondsLong),
                            style = MaterialTheme.typography.displaySmall,
                            color = MaterialTheme.colorScheme.secondary,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = MaterialTheme.shapes.medium.copy(
                                bottomEnd = CornerSize(0),
                                bottomStart = CornerSize(0)
                            )
                        )
                        .padding(30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Shuffle button
                    IconButton(onClick = { viewModel.shuffle() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.shuffle),
                            contentDescription = stringResource(id = R.string.shuffle),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    // Play previous button
                    IconButton(onClick = { viewModel.playPrevious() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.skip_previous),
                            contentDescription = stringResource(id = R.string.play_previous),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    PlayPauseButton(isPaused = !viewModel.musicPlaying) {
                        if (viewModel.musicPlaying) viewModel.pause() else viewModel.resume()
                    }
                    // Play next button
                    IconButton(onClick = { viewModel.playPrevious() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.skip_next),
                            contentDescription = stringResource(id = R.string.play_next),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    // Repeat button
                    IconButton(onClick = { viewModel.playPrevious() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.replay),
                            contentDescription = stringResource(id = R.string.repeat),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}

private fun formatMusicTime(secondsLong: Int): String {
    val minutes = secondsLong / 60
    val seconds = secondsLong % 60
    return "$minutes:${if (seconds == 0) "00" else seconds}"
}
