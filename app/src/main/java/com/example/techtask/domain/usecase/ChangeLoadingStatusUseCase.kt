package com.example.techtask.domain.usecase

import com.example.techtask.domain.store.AlbumsStore
import javax.inject.Inject

class ChangeLoadingStatusUseCase @Inject constructor(private val store: AlbumsStore) {
    operator fun invoke(isLoading: Boolean) {
        store.isLoading.tryEmit(isLoading)
    }
}