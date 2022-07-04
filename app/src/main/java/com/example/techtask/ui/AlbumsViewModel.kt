package com.example.techtask.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.techtask.data.AlbumsRepository
import com.example.techtask.data.models.Album
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AlbumsViewModel @Inject constructor(private val repository: AlbumsRepository) : ViewModel() {

    init {
        fetchAlbums()
    }

    private val _albumListState = MutableStateFlow<List<Album>>(emptyList())
    val albumListState = _albumListState.asStateFlow()

    private val _favouriteAlbums = MutableStateFlow<List<Album>>(mutableListOf())
    val favouriteAlbums = _favouriteAlbums.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private fun fetchAlbums() {
        viewModelScope.launch {
            val response = repository.getAlbums()

            if (response.isSuccessful) {
                _albumListState.tryEmit(
                    response.body().orEmpty().sortedBy { it.title }
                )
                _isLoading.value = false
            } else {
                Log.e("Error Loading", response.errorBody().toString())
            }
        }
    }

    fun addFavourite(item: Album) {
        _favouriteAlbums.value = _favouriteAlbums.value + item
    }

    fun removeFavourite(item: Album) {
        _favouriteAlbums.value = _favouriteAlbums.value - item
    }
}