package com.cabovianco.thenbhd.ui.screen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cabovianco.thenbhd.R
import com.cabovianco.thenbhd.data.repository.model.Album
import com.cabovianco.thenbhd.data.repository.model.Song
import com.cabovianco.thenbhd.ui.screen.view.shared.SongItem
import com.cabovianco.thenbhd.ui.screen.viewModel.AlbumViewModel
import com.cabovianco.thenbhd.ui.theme.jetBrainsFont

@Composable
fun AlbumScreen(modifier: Modifier = Modifier, viewModel: AlbumViewModel = hiltViewModel()) {
    val albums by viewModel.albums.collectAsState()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        albums.forEach {
            item { AlbumItem(modifier = Modifier.padding(vertical = 8.dp), album = it) }
        }
    }
}

@Composable
private fun AlbumItem(modifier: Modifier = Modifier, album: Album) {
    val clicked = rememberSaveable { mutableStateOf(false) }

    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        onClick = { clicked.value = true }
    ) {
        AlbumItemDetails(album = album)
    }

    if (clicked.value) {
        AlbumItemSongs(clicked = clicked, songs = album.songs)
    }
}

@Composable
private fun AlbumItemDetails(modifier: Modifier = Modifier, album: Album) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AlbumItemTitle(title = album.name)
        AlbumItemGenre(genre = album.genre)
        AlbumItemSongsCounter(songsCounter = album.songs.size)
        AlbumItemRelease(release = album.release)
    }
}

@Composable
private fun AlbumItemTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        text = title,
        modifier = modifier.padding(vertical = 6.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = jetBrainsFont
    )
}

@Composable
private fun AlbumItemGenre(modifier: Modifier = Modifier, genre: String) {
    Text(
        text = "Genre: $genre",
        modifier = modifier,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = jetBrainsFont
    )
}

@Composable
private fun AlbumItemSongsCounter(modifier: Modifier = Modifier, songsCounter: Int) {
    Text(
        text = "Songs: $songsCounter",
        modifier = modifier,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = jetBrainsFont
    )
}

@Composable
private fun AlbumItemRelease(modifier: Modifier = Modifier, release: String) {
    Text(
        text = "Release: $release",
        modifier = modifier,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = jetBrainsFont
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AlbumItemSongs(
    modifier: Modifier = Modifier,
    clicked: MutableState<Boolean>,
    songs: List<Song>
) {
    ModalBottomSheet(
        onDismissRequest = { clicked.value = false },
        modifier = modifier.fillMaxWidth()
    ) {
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            item { ModalBottomSheetTitle() }

            songs.forEach {
                item { SongItem(modifier = Modifier.padding(vertical = 8.dp), song = it) }
            }
        }
    }
}

@Composable
private fun ModalBottomSheetTitle(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.song),
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp)
        )

        Text(
            text = "Songs",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = jetBrainsFont
        )
    }
}
