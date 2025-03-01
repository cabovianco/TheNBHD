package com.cabovianco.thenbhd.data.repository.model

data class Album(
    val name: String,
    val genre: String,
    val songs: List<Song>,
    val release: String
)
