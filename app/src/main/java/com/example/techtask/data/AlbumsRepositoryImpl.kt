package com.example.techtask.data

import com.example.techtask.domain.models.Album
import com.example.techtask.domain.repository.AlbumsRepository
import javax.inject.Inject
import retrofit2.Response

class AlbumsRepositoryImpl @Inject constructor() : AlbumsRepository {

    override suspend fun getAlbums(): Response<List<Album>> {
        return RetrofitInstance.api.getAlbums()
    }
}