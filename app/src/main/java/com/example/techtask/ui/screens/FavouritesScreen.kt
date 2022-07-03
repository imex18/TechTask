package com.example.techtask.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.techtask.ui.AlbumsViewModel
import com.example.techtask.ui.views.AlbumItemView

@Composable
fun FavouritesScreen(viewModel: AlbumsViewModel = hiltViewModel()) {

    val state by viewModel.albumListState.collectAsState()

    LazyColumn(modifier = Modifier.background(color = Color.Transparent)) {
        itemsIndexed(items = state) { index, listItem ->
            AlbumItemView(
                modifier = Modifier.padding(top = if (index == 0) 5.dp else 0.dp),
                albumItem = listItem,
                onFavouriteClicked = {}
            )
        }
    }
}
