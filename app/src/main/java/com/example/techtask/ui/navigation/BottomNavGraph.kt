package com.example.techtask.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.techtask.ui.AlbumsViewModel
import com.example.techtask.ui.screens.AlbumListScreen
import com.example.techtask.ui.screens.FavouritesScreen

@Composable
fun BottomNavGraph(navController: NavHostController, viewModel: AlbumsViewModel) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationMenu.Home.route
    ) {
        composable(route = BottomNavigationMenu.Home.route) {
            AlbumListScreen(viewModel = viewModel)
        }
        composable(route = BottomNavigationMenu.Favourites.route) {
            FavouritesScreen(viewModel = viewModel)
        }
    }
}