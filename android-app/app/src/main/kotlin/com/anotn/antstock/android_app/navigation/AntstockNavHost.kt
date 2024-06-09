package com.anotn.antstock.android_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.ActivityNavigator
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anotn.antstock.android_app.ui.AntstockAppState
import com.anotn.antstock.home.navigation.homeScreen
import com.anotn.antstock.home.navigation.navigateToHome

@Composable
fun AntstockNavHost(
    appState: AntstockAppState,
    modifier: Modifier = Modifier,
    startDestination: String = "HOME"
) {
    val navController = appState.navController
    NavHost(navController = navController,
        startDestination = startDestination,
        modifier = modifier) {
            homeScreen(onTopicClick = {navController::navigateToHome})

    }
}