package com.example.techtask.data

import com.example.techtask.data.models.Album
import retrofit2.Response
import retrofit2.http.GET

interface AlbumsApi {

    @GET("/albums")
    suspend fun getAlbums(): Response<List<Album>>
}