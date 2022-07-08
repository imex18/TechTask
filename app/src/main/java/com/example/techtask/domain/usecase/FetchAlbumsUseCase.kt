package com.example.techtask.domain.usecase

import android.util.Log
import com.example.techtask.domain.repository.AlbumsRepository
import com.example.techtask.domain.store.AlbumsStore
import com.example.techtask.domain.store.ErrorState
import java.net.SocketTimeoutException
import javax.inject.Inject

class FetchAlbumsUseCase @Inject constructor(
    private val repository: AlbumsRepository,
    private val store: AlbumsStore,
    private val changeLoadingStatus: ChangeLoadingStatusUseCase
) {

    suspend operator fun invoke() {
        changeLoadingStatus(true)
        try {
            val result = repository.getAlbums()
            store.albums.tryEmit(result.body().orEmpty().sortedBy { it.title })
            changeLoadingStatus(false)
        } catch (e: SocketTimeoutException) {
            changeLoadingStatus(false)
            store.errorState.tryEmit(ErrorState.NetworkError)
            Log.e("Network Error", e.message.orEmpty())
        }
    }
}