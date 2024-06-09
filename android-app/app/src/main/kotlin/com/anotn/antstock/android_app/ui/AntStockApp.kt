package com.anotn.antstock.android_app.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.anotn.antstock.android_app.R
import com.anotn.antstock.android_app.navigation.AntstockNavHost
import com.anotn.antstock.android_app.navigation.TopLevelDestination

@Composable
internal fun AntstockApp(
    appState: AntstockAppState
) {
   val topLevelDestination = listOf(
       BottomNavItem.Home,
       BottomNavItem.Market,
       BottomNavItem.News,
       BottomNavItem.Shop,
       BottomNavItem.Setting
   )
    Scaffold(
        bottomBar = {
            NavigationBar(){
                topLevelDestination.forEach { item ->
                    NavigationBarItem(
                        selected = appState.currentDestination?.route == item.route,
                        onClick = { appState.navigateToTopLevelDestination(item as TopLevelDestination) },
                        icon = {
                        },
                        label = { Text(item.title) }
                    )
                }
            }
        },
    ) { padding ->
                    AntstockNavHost(
                        appState = appState,
                        modifier = Modifier.padding(padding)
                    )
                }
}

sealed class BottomNavItem(val title: String, val icon: Int, val route: String) {
    object Home : BottomNavItem("홈", R.drawable.ic_home, "HOME")
    object Market : BottomNavItem("주식", R.drawable.ic_market, "MARKET")
    object News : BottomNavItem("뉴스", R.drawable.ic_news, "NEWS")
    object Shop : BottomNavItem("상점", R.drawable.ic_shop, "SHOP")
    object Setting : BottomNavItem("전체", R.drawable.ic_more, "SETTING")




}