package com.example.techtask.domain.repository

import com.example.techtask.data.RetrofitInstance
import com.example.techtask.domain.models.Album
import retrofit2.Response

interface AlbumsRepository {

    suspend fun getAlbums(): Response<List<Album>> {
        return RetrofitInstance.api.getAlbums()
    }
}