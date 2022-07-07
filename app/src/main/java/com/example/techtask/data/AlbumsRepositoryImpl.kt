package com.example.techtask.data

import android.content.Context
import com.example.techtask.domain.models.Album
import com.example.techtask.domain.repository.AlbumsRepository
import javax.inject.Inject
import retrofit2.Response

class AlbumsRepositoryImpl @Inject constructor(private val context: Context) : AlbumsRepository {

    private val sharedPref = context.getSharedPreferences(
        "Favourites", Context.MODE_PRIVATE
    )

    override suspend fun getAlbums(): Response<List<Album>> {
        return RetrofitInstance.api.getAlbums()
    }

    override fun saveFavAlbumsIds(ids: String) {
        sharedPref
            .edit()
            .putString("ids", ids)
            .apply()
    }

    override fun getFavAlbumsIds(): String? {
        return sharedPref.getString("ids", null)
    }
}