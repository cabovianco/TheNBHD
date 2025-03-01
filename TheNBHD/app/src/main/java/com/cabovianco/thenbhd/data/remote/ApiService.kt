package com.cabovianco.thenbhd.data.remote

import com.cabovianco.thenbhd.data.remote.dto.AlbumDto
import com.cabovianco.thenbhd.data.remote.dto.SongDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("albums")
    suspend fun getAllAlbums(): Response<List<AlbumDto>>

    @GET("albums/{id}")
    suspend fun getAlbumById(@Path("id") id: Long): Response<AlbumDto>

    @GET("songs")
    suspend fun getAllSongs(): Response<List<SongDto>>

    @GET("songs/{id}")
    suspend fun getSongById(@Path("id") id: Long): Response<SongDto>

}
