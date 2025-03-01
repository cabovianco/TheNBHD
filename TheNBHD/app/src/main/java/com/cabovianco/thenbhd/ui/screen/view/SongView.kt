package com.cabovianco.thenbhd.ui.screen.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cabovianco.thenbhd.ui.screen.view.shared.SongItem
import com.cabovianco.thenbhd.ui.screen.viewModel.SongViewModel

@Composable
fun SongScreen(modifier: Modifier = Modifier, viewModel: SongViewModel = hiltViewModel()) {
    val songs by viewModel.songs.collectAsState()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        songs.forEach {
            item {
                SongItem(modifier = Modifier.padding(vertical = 8.dp), song = it)
            }
        }
    }
}
