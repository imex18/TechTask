package com.example.techtask.domain

import android.util.Log
import javax.inject.Inject

class FetchAlbumsUseCase @Inject constructor(
    private val repository: AlbumsRepository,
    private val store: AlbumsStore,
    private val changeLoadingStatus: ChangeLoadingStatusUseCase
) {

    suspend operator fun invoke() {
        changeLoadingStatus(true)
        val result = repository.getAlbums()

        if (result.isSuccessful) {
            store.albums.tryEmit(result.body().orEmpty().sortedBy { it.title })
            changeLoadingStatus(false)
        } else {
            Log.e("Error Loading", result.errorBody().toString())
        }
    }
}