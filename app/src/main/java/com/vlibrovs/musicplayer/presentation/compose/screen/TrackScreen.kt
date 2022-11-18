package com.vlibrovs.musicplayer.presentation.compose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.InternalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vlibrovs.musicplayer.presentation.viewmodel.MainViewModel
import com.vlibrovs.musicplayer.R
import com.vlibrovs.musicplayer.presentation.compose.widget.NullableAsyncImage

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
                    .padding(30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowDropDown,
                        contentDescription = stringResource(id = R.string.collapse)
                    )
                }
                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = stringResource(id = R.string.menu)
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
            }

        }

    }
}