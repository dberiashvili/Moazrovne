package com.dberiashvili.moazrovne.ui.navigation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dberiashvili.moazrovne.R
import com.dberiashvili.moazrovne.ui.QuestionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(navController: NavController, viewModel: QuestionViewModel) {
    val items = listOf(
        BottomNavItem(
            name = "მთავარი",
            route = "home",
            icon = R.drawable.home,
        ),
        BottomNavItem(
            name = "თამაში",
            route = "game",
            icon = R.drawable.games,
        ),
        BottomNavItem(
            name = "შენახული კითხვები",
            route = "favorites",
            icon = R.drawable.baseline_favorite_24,
            badgeCount = viewModel.savedQuestions.collectAsState().value.size
        )
    )



    val backStackEntry = navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            androidx.compose.material3.NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                items.forEach { item ->
                    val selected = item.route == backStackEntry.value?.destination?.route

                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = {
                                Text(
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    text = item.name,
                                    fontWeight = FontWeight.SemiBold,
                                )
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount > 0) {
                                        Badge { Text(item.badgeCount.toString()) }
                                    }
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = "favorites"
                                )
                            }
                        }
                    )
                }
            }
        }, content = {
            Box(modifier = Modifier.padding(it)){
                NavigationGraph(navController = navController as NavHostController)
            }

        }
    )
}


