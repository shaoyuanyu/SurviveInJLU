package com.yusy.surviveinjlu.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.yusy.surviveinjlu.R

class MyNavActions(private val navHostController: NavHostController) {
    fun getNavHostController(): NavHostController = navHostController

    /**
     * 导航到顶级目的地
     */
    fun navigateToTop(destination: TopLevelDestination) {
        navHostController.navigate(destination.route) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = false
            }
            launchSingleTop = true
            restoreState = false
        }
    }

    /**
     * 导航到次级目的地
     */
    fun navigateToSecond(destination: SecondLevelDestination) {
        val route = if (destination.params.isNotEmpty()) {
            destination.route + "/" + destination.route
        } else {
            destination.route
        }

        navHostController.navigate(route) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = false
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    /**
     * 导航到子级目的地
     * (次级目的地之间)
     */
    fun navigateToChild(destination: SecondLevelDestination) {
        val route = if (destination.params.isNotEmpty()) {
            destination.route + "/" + destination.route
        } else {
            destination.route
        }

        navHostController.navigate(route) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateBack() {
        navHostController.navigateUp()
    }
}

object MyRoutes {
    const val HOME = "HOME"
    const val JLU = "JLU"
    const val MINE = "MINE"
}

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = MyRoutes.HOME,
        unselectedIconId = R.drawable.ic_overview,
        selectedIconId = R.drawable.ic_overview,
        iconTextId = R.string.nav_dest_tab_home
    ),
    TopLevelDestination(
        route = MyRoutes.JLU,
        unselectedIconId = R.drawable.ic_jlu,
        selectedIconId = R.drawable.ic_jlu,
        iconTextId = R.string.nav_dest_tab_jlu
    ),
    TopLevelDestination(
        route = MyRoutes.MINE,
        unselectedIconId = R.drawable.ic_mine,
        selectedIconId = R.drawable.ic_mine,
        iconTextId = R.string.nav_dest_tab_mine
    ),
)

data class TopLevelDestination(
    val route: String,
    val unselectedIconId: Int,
    val selectedIconId: Int,
    val iconTextId: Int
)

fun judgeTopDestination(selectedDestination: String): Boolean =
    (selectedDestination == MyRoutes.HOME) || (selectedDestination == MyRoutes.JLU) || (selectedDestination == MyRoutes.MINE)

data class SecondLevelDestination(
    val route: String,
    val params: String
)