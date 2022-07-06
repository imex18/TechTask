package com.example.techtask.domain

import javax.inject.Inject

class ChangeLoadingStatusUseCase @Inject constructor(private val store: AlbumsStore) {
    operator fun invoke(isLoading: Boolean) {
        store.isLoading.tryEmit(isLoading)
    }
}