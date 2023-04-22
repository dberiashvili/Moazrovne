package com.dberiashvili.moazrovne.ui.navigation


data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: Int,
    var badgeCount: Int = 0,
)
