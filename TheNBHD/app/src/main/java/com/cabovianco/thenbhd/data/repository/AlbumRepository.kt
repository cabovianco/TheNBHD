package com.cabovianco.thenbhd.data.repository

import com.cabovianco.thenbhd.data.remote.ApiService
import com.cabovianco.thenbhd.data.remote.dto.toModel
import com.cabovianco.thenbhd.data.repository.model.Album
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlbumRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getAllAlbums(): List<Album> {
        val response = apiService.getAllAlbums()
        if (response.isSuccessful) {
            return response.body()?.map { it.toModel() } ?: emptyList()
        }

        return emptyList()
    }

    suspend fun getAlbumById(id: Long): Album? {
        val response = apiService.getAlbumById(id)
        if (response.isSuccessful) {
            return response.body()?.toModel()
        }

        return null
    }

}
