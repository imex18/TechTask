package com.example.techtask.data

import com.example.techtask.data.models.Album
import com.example.techtask.domain.AlbumsRepository
import javax.inject.Inject
import retrofit2.Response

class AlbumsRepositoryImpl @Inject constructor() : AlbumsRepository {

    override suspend fun getAlbums(): Response<List<Album>> {
        return RetrofitInstance.api.getAlbums()
    }
}