package com.cabovianco.thenbhd.ui.screen.view.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cabovianco.thenbhd.data.repository.model.Song
import com.cabovianco.thenbhd.ui.theme.jetBrainsFont

@Composable
fun SongItem(modifier: Modifier = Modifier, song: Song) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            SongItemTitle(title = song.name)
            SongItemDuration(duration = song.durationInSeconds)
        }
    }
}

@Composable
private fun SongItemTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        text = title,
        modifier = modifier.padding(vertical = 6.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = jetBrainsFont
    )
}

@Composable
private fun SongItemDuration(modifier: Modifier = Modifier, duration: Int) {
    val minutes = duration / 60
    val seconds = duration % 60

    Text(
        text = "Duration: $minutes:$seconds",
        modifier = modifier.padding(vertical = 6.dp),
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = jetBrainsFont
    )
}
