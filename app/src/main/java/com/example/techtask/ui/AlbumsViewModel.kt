package com.example.techtask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.techtask.domain.usecase.AddFavouriteUseCase
import com.example.techtask.domain.usecase.FetchAlbumsUseCase
import com.example.techtask.domain.usecase.FetchFavouritesUseCase
import com.example.techtask.domain.usecase.RemoveFavouriteUseCase
import com.example.techtask.domain.usecase.SaveFavouritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val fetchAlbums: FetchAlbumsUseCase,
    private val addFavourite: AddFavouriteUseCase,
    private val removeFavourite: RemoveFavouriteUseCase,
    private val saveFavourites: SaveFavouritesUseCase,
    private val fetchFavourites: FetchFavouritesUseCase,
    private val uiMapper: MainScreenUiMapper
) : ViewModel() {


    val uiState = uiMapper.map(viewModelScope)

    fun onAddFavourite(albumId: Int) {
        addFavourite(albumId)
    }

    fun onRemoveFavourite(albumId: Int) {
        removeFavourite(albumId)
    }

    fun onActivityCreated() {
        viewModelScope.launch {
            fetchAlbums()
            fetchFavourites()
        }
    }

    fun onActivityStopped() {
        viewModelScope.launch {
            saveFavourites()
        }
    }
}