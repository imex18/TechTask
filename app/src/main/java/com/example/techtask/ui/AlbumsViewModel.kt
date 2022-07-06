package com.example.techtask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.techtask.domain.AddFavouriteUseCase
import com.example.techtask.domain.FetchAlbumsUseCase
import com.example.techtask.domain.RemoveFavouriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val fetchAlbums: FetchAlbumsUseCase,
    private val addFavourite: AddFavouriteUseCase,
    private val removeFavourite: RemoveFavouriteUseCase,
    private val uiMapper: MainScreenUiMapper
) : ViewModel() {

    init {
        viewModelScope.launch {
            fetchAlbums()
        }
    }

    val uiState = uiMapper.map(viewModelScope)

    fun onAddFavourite(albumId: Int) {
        addFavourite(albumId)
    }

    fun onRemoveFavourite(albumId: Int) {
        removeFavourite(albumId)
    }
}