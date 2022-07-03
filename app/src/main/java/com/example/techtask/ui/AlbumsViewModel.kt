package com.example.techtask.ui

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

    private val _albumListState = MutableStateFlow(listOf(Album()))
    val albumListState = _albumListState.asStateFlow()

    private fun fetchAlbums() {
        viewModelScope.launch {
            val albums = repository.getAlbums().body().orEmpty()
            _albumListState.value = albums
        }
    }
}