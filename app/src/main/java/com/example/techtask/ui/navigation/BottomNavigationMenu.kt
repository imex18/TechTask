package com.example.techtask.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationMenu(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavigationMenu(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Favourites : BottomNavigationMenu(
        route = "favourites",
        title = "Favourites",
        icon = Icons.Default.Favorite
    )
}
