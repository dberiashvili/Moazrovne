package com.dberiashvili.moazrovne.ui.navigation

import com.dberiashvili.moazrovne.R

enum class Screens(val title: String, val icon: Int, val route: String) {
    Home("მთავარი", R.drawable.home, "home"),
    Game("თამაში", R.drawable.games, "game_screen"),
    Favorites("შენახული კითხვები", R.drawable.baseline_favorite_24, "favorites")
}