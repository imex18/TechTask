package com.example.techtask.domain.usecase

import com.example.techtask.domain.store.AlbumsStore
import com.example.techtask.domain.store.ErrorState
import javax.inject.Inject

class ResetErrorStateUseCase @Inject constructor(private val store: AlbumsStore) {
    operator fun invoke() {
        store.errorState.tryEmit(ErrorState.Unknown)
    }
}