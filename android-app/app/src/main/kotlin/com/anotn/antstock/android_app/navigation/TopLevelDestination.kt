package com.anotn.antstock.android_app.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.anotn.antstock.android_app.R

enum class TopLevelDestination(
    val selectedIcon : Int,
    val unselectedIcon : Int,
    val iconTextId : String,
    val titleTextId : String
) {
    HOME(
        selectedIcon = R.drawable.ic_home,
        unselectedIcon = R.drawable.ic_home,
        iconTextId = "home",
        titleTextId = "home",
    ),
    MARKET(
        selectedIcon = R.drawable.ic_market,
        unselectedIcon = R.drawable.ic_market,
        iconTextId = "market",
        titleTextId = "market",
    ),

    NEWS(
        selectedIcon = R.drawable.ic_news,
        unselectedIcon = R.drawable.ic_news,
        iconTextId = "news",
        titleTextId = "news",
    ),

    SHOP(
        selectedIcon = R.drawable.ic_shop,
        unselectedIcon = R.drawable.ic_shop,
        iconTextId = "shop",
        titleTextId = "shop",
    ),

    ACCOUNT(
        selectedIcon = R.drawable.ic_more,
        unselectedIcon = R.drawable.ic_more,
        iconTextId = "account",
        titleTextId = "account",
    ),
}