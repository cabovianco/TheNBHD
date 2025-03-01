package com.cabovianco.thenbhd.data.remote.dto

import com.cabovianco.thenbhd.data.repository.model.Album

data class AlbumDto(
    val id: Long,
    val name: String,
    val genre: String,
    val songs: List<SongDto>,
    val release: String
)

fun AlbumDto.toModel() = Album(
    name = name,
    genre = genre,
    songs = songs.map { it.toModel() },
    release = release
)
