package com.yusy.surviveinjlu.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yusy.surviveinjlu.ui.navigation.MyNavActions
import com.yusy.surviveinjlu.ui.navigation.MyNavGraph
import com.yusy.surviveinjlu.ui.navigation.MyRoutes
import com.yusy.surviveinjlu.ui.theme.SurviveInJLUTheme

/**
 * UI入口，指向MyNavGraph
 */
@Composable
fun MyContent() {
    val navController = rememberNavController()
    val myNavActions = remember(navController) {
        MyNavActions(navController)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination = navBackStackEntry?.destination?.route ?: MyRoutes.HOME

    SurviveInJLUTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyNavGraph(
                myNavActions = myNavActions,
                selectedDestination = selectedDestination
            )
        }
    }
}