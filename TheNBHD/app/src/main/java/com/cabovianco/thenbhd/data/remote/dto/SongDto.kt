package com.cabovianco.thenbhd.data.remote.dto

import com.cabovianco.thenbhd.data.repository.model.Song

data class SongDto(
    val id: Long,
    val name: String,
    val durationInSeconds: Int
)

fun SongDto.toModel() = Song(
    name = name,
    durationInSeconds = durationInSeconds
)
