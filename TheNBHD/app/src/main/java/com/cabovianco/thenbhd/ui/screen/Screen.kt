package com.cabovianco.thenbhd.ui.screen

import androidx.annotation.DrawableRes
import com.cabovianco.thenbhd.R

sealed class Screen(
    val route: String,
    val name: String,
    @DrawableRes val iconId: Int
) {

    data object AlbumScreen : Screen("album", "Albums", R.drawable.album)
    data object SongScreen : Screen("song", "Songs", R.drawable.song)

}
