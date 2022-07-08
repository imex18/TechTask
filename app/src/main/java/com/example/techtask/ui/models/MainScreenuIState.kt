package com.example.techtask.ui.models

import com.example.techtask.domain.store.ErrorState

data class MainScreenUiState(val albumsList: List<AlbumItem>, val isLoading: Boolean, val errorState: ErrorState)