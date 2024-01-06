package com.yusy.surviveinjlu.ui.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

/**
 * Navigation Bar
 */
@Composable
fun NavBar(
    myNavActions: MyNavActions,
    selectedDestination: String
) {
    NavigationBar {
        TOP_LEVEL_DESTINATIONS.forEach {
            NavigationBarItem(
                selected = selectedDestination == it.route,
                onClick = {
                    myNavActions.navigateToTop(it)
                },
                icon = {
                    if (selectedDestination != it.route) {
                        Icon(painter = painterResource(it.unselectedIconId), contentDescription = stringResource(it.iconTextId), modifier = Modifier.size(24.dp))
                    } else {
                        Icon(painter = painterResource(it.selectedIconId), contentDescription = stringResource(it.iconTextId), modifier = Modifier.size(24.dp))
                    }
                },
                label = {
                    Text(stringResource(it.iconTextId))
                }
            )
        }
    }
}