package com.example.techtask.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.techtask.ui.AlbumsViewModel
import com.example.techtask.ui.views.AlbumItemView
import com.example.techtask.ui.views.LoadingView

@Composable
fun AlbumListScreen(viewModel: AlbumsViewModel) {

    val albums by viewModel.albumListState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val favourites by viewModel.favouriteAlbums.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.background(color = Color.Transparent)) {
            itemsIndexed(items = albums) { index, listItem ->
                AlbumItemView(
                    modifier = Modifier.padding(top = if (index == 0) 5.dp else 0.dp),
                    albumItem = listItem,
                    isSavedToFavourites = listItem in favourites,
                    onFavouriteClicked = {
                        if (listItem in favourites) {
                            viewModel.removeFavourite(listItem)
                        } else {
                            viewModel.addFavourite(listItem)
                        }
                    }
                )
            }
        }

        if (isLoading) {
            LoadingView()
        }
    }
}
