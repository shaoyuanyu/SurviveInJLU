package com.yusy.surviveinjlu.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.yusy.surviveinjlu.ui.pages.empty.EmptyScreen
import com.yusy.surviveinjlu.ui.pages.home.HomeScreen

/**
 * Navigation Graph
 */
@Composable
fun MyNavGraph(
    myNavActions: MyNavActions,
    selectedDestination: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // main content
        NavHost(
            modifier = if (judgeTopDestination(selectedDestination)) {
                modifier.weight(1f)
            } else {
                modifier
            },
            navController = myNavActions.getNavHostController(),
            startDestination = MyRoutes.HOME
        ) {
            // top level
            composable(MyRoutes.HOME) {
                HomeScreen()
            }
            composable(MyRoutes.JLU) {
                EmptyScreen()
            }
            composable(MyRoutes.MINE) {
                EmptyScreen()
            }

            // second level
        }

        // nav bar
        if (judgeTopDestination(selectedDestination)) {
            NavBar(myNavActions = myNavActions, selectedDestination = selectedDestination)
        }
    }
}