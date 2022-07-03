package com.example.techtask.data

import com.example.techtask.data.models.Album
import javax.inject.Inject
import retrofit2.Response

class AlbumsRepository @Inject constructor() {

    suspend fun getAlbums(): Response<List<Album>> {
        return RetrofitInstance.api.getAlbums()
    }
}