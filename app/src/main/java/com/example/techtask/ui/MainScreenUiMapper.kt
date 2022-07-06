package com.example.techtask.ui

import com.example.techtask.domain.store.AlbumsStore
import com.example.techtask.ui.models.AlbumItem
import com.example.techtask.ui.models.MainScreenUiState
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn

class MainScreenUiMapper @Inject constructor(private val albumStore: AlbumsStore) {
    fun map(scope: CoroutineScope): StateFlow<MainScreenUiState> {
        return combine(
            albumStore.albums,
            albumStore.favourites,
            albumStore.isLoading,
            transform = { albums, favourites, isLoading ->
                val albumsList = albums.map {
                    AlbumItem(id = it.id.toString(), title = it.title, isFavourite = it.id in favourites)
                }
                MainScreenUiState(albumsList = albumsList, isLoading = isLoading)
            }
        )
            .flowOn(Dispatchers.IO)
            .stateIn(scope, SharingStarted.WhileSubscribed(), MainScreenUiState(emptyList(), false))
    }
}

