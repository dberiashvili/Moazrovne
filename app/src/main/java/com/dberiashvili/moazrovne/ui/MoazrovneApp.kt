package com.dberiashvili.moazrovne.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.dberiashvili.moazrovne.ui.navigation.BottomNavigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MoazrovneApp() {
    val navController = rememberNavController()
    val viewModel: QuestionViewModel = hiltViewModel()
    BottomNavigation(navController = navController, viewModel = viewModel)


}