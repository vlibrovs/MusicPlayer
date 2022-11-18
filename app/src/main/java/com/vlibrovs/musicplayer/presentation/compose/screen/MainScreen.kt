package com.vlibrovs.musicplayer.presentation.compose.screen

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.vlibrovs.musicplayer.R
import com.vlibrovs.musicplayer.data.model.Track
import com.vlibrovs.musicplayer.presentation.compose.widget.MusicListItem
import com.vlibrovs.musicplayer.presentation.compose.widget.NullableAsyncImage
import com.vlibrovs.musicplayer.presentation.compose.widget.PlayPauseButton
import com.vlibrovs.musicplayer.presentation.viewmodel.MainViewModel
import com.vlibrovs.musicplayer.util.extension.rememberConstraintSet

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val constraintSet = rememberConstraintSet {
        val lazyColumn = createRefFor(id = "lazyColumn")
        val bottomPlayer = createRefFor(id = "bottomPlayer")
        constrain(bottomPlayer) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }
        constrain(lazyColumn) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(bottomPlayer.top)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        constraintSet = constraintSet
    ) {
        LazyColumn(modifier = Modifier.layoutId("lazyColumn")) {
            items(viewModel.playlist.size) { index ->
                MusicListItem(
                    track = viewModel.playlist[index],
                    isPlaying = index == viewModel.playingTrackNumber
                ) {
                    viewModel.playTrackByIndex(index)
                }
            }
        }
        AnimatedVisibility(
            visible = viewModel.bottomPlayerVisible,
            modifier = Modifier.layoutId("bottomPlayer"),
            enter = slideInVertically { it },
            exit = slideOutVertically { it }
        ) {
            viewModel.playingTrack?.let { track ->
                Row(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = MaterialTheme.shapes.medium.copy(
                                bottomEnd = CornerSize(0),
                                bottomStart = CornerSize(0)
                            )
                        )
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NullableAsyncImage(
                        modifier = Modifier
                            .size(80.dp)
                            .background(
                                shape = MaterialTheme.shapes.medium,
                                color = MaterialTheme.colorScheme.secondary
                            ),
                        url = track.imageUrl,
                        contentDescription = track.name
                    )

                    Spacer(modifier = Modifier.width(30.dp))
                    Column(
                        modifier = Modifier.height(80.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = track.name,
                            style = MaterialTheme.typography.displayMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = track.authorName,
                            style = MaterialTheme.typography.displaySmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp), contentAlignment = Alignment.CenterEnd
                    ) {
                        PlayPauseButton(isPaused = !viewModel.musicPlaying) {
                            if (viewModel.musicPlaying) viewModel.pause() else viewModel.resume()
                        }
                    }
                }

            }
        }
    }
}