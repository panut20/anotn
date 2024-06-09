package com.anotn.antstock.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.anotn.antstock.home.HomeScreen

fun NavController.navigateToHome(navOptions: NavOptions) = navigate("HOME", navOptions)

fun NavGraphBuilder.homeScreen(
    onTopicClick: (String) -> Unit) {
    composable(route = "HOME") {
        HomeScreen(onTopicClick = onTopicClick)
    }

}