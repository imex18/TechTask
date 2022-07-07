package com.example.techtask.domain.usecase

import com.example.techtask.domain.repository.AlbumsRepository
import com.example.techtask.domain.store.AlbumsStore
import javax.inject.Inject

class SaveFavouritesUseCase @Inject constructor(
    private val repository: AlbumsRepository,
    private val store: AlbumsStore
) {

    operator fun invoke() {
        val idsString = store.favourites.value.joinToString { it.toString() }
        repository.saveFavAlbumsIds(idsString)
    }
}