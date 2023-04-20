package com.dberiashvili.moazrovne.ui

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

import com.dberiashvili.moazrovne.ui.navigation.BottomNavigation
import com.dberiashvili.moazrovne.ui.navigation.NavigationGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MoazrovneApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {

        NavigationGraph(navController = navController)
    }


}