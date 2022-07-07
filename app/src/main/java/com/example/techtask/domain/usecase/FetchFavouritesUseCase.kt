package com.example.techtask.domain.usecase

import com.example.techtask.domain.repository.AlbumsRepository
import com.example.techtask.domain.store.AlbumsStore
import javax.inject.Inject

class FetchFavouritesUseCase @Inject constructor(
    private val repository: AlbumsRepository,
    private val store: AlbumsStore
) {

    operator fun invoke() {
        val idsString = repository.getFavAlbumsIds().orEmpty()
        if (idsString.isNotEmpty()) {
            val idsIntList = idsString.split(",", " ").filter { it.isNotEmpty() }.map { it.toInt() }
            store.favourites.value = idsIntList
        }
    }
}
