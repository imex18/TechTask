package com.example.techtask.domain

import com.example.techtask.data.models.Album
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow

@Singleton
class AlbumsStore @Inject constructor() {

    val albums = MutableStateFlow<List<Album>>(emptyList())
    val favourites = MutableStateFlow<List<Int>>(emptyList())
    val isLoading = MutableStateFlow(false)
}