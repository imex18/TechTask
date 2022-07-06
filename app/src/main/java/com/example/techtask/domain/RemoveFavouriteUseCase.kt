package com.example.techtask.domain

import javax.inject.Inject

class RemoveFavouriteUseCase @Inject constructor(private val store: AlbumsStore) {

    operator fun invoke(albumId: Int) {
        store.favourites.value = store.favourites.value - albumId
    }
}