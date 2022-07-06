package com.example.techtask.domain.usecase

import android.util.Log
import com.example.techtask.domain.repository.AlbumsRepository
import com.example.techtask.domain.store.AlbumsStore
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