package com.anotn.antstock.market.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.anotn.antstock.market.MarketScreen

fun NavController.navigateToMarket(navOptions: NavOptions) = navigate("MARKET", navOptions)

fun NavGraphBuilder.marketScreen(

) {
    composable("MARKET") {
    }

}