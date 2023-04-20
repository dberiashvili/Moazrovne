package com.dberiashvili.moazrovne.ui.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dberiashvili.moazrovne.ui.screens.FavoriteScreen
import com.dberiashvili.moazrovne.ui.screens.QuestionsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            QuestionsScreen()
        }

        composable(Screens.Game.route) {
            QuestionsScreen()
        }

        composable(Screens.Favorites.route) {
            FavoriteScreen()
        }
    }
}