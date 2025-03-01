package com.cabovianco.thenbhd.data.repository

import com.cabovianco.thenbhd.data.remote.ApiService
import com.cabovianco.thenbhd.data.remote.dto.toModel
import com.cabovianco.thenbhd.data.repository.model.Song
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SongRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getAllSongs(): List<Song> {
        val response = apiService.getAllSongs()
        if (response.isSuccessful) {
            return response.body()?.map { it.toModel() } ?: emptyList()
        }

        return emptyList()
    }

    suspend fun getSongById(id: Long): Song? {
        val response = apiService.getSongById(id)
        if (response.isSuccessful) {
            return response.body()?.toModel()
        }

        return null
    }

}
