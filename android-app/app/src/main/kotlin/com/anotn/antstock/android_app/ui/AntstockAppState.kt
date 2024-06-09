package com.anotn.antstock.android_app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.util.trace
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.anotn.antstock.android_app.navigation.TopLevelDestination
import com.anotn.antstock.home.navigation.navigateToHome
import com.anotn.antstock.market.navigation.navigateToMarket
import com.apollographql.apollo3.network.NetworkMonitor
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAntstockAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
) : AntstockAppState {
    return remember(
        navController,
        coroutineScope,
    ) {
        AntstockAppState(
            navController = navController,
            coroutineScope = coroutineScope,
        )
    }
}


@Stable
class AntstockAppState(
    val navController : NavHostController,
    coroutineScope: CoroutineScope,
    ) {
    val currentDestination : NavDestination?
            @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination
    val currentTopLevelDestination : TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            "HOME" -> TopLevelDestination.HOME
            "MARKET" -> TopLevelDestination.MARKET
            else -> null
        }

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries


    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
            }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
        }
            when (topLevelDestination) {
                TopLevelDestination.HOME -> navController.navigateToHome(topLevelNavOptions)
                TopLevelDestination.MARKET -> navController.navigateToMarket(topLevelNavOptions)
                TopLevelDestination.NEWS -> TODO()
                TopLevelDestination.SHOP -> TODO()
                TopLevelDestination.ACCOUNT -> TODO()
            }
        }
    }
}

