package com.anotn.antstock.market

import android.view.MenuItem
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketScreen(
    onMenuItemClick: (MenuItem) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("종목 검색") },
                actions = {
                    // 앱바 메뉴 아이템들
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Search, contentDescription = null)
                    }
                    // 다른 메뉴 아이템들
                }
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            StockList(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun StockList(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(count = 5) { stock ->
            StockItem(stock = stock)
        }
    }
}

@Composable
fun StockItem(
    stock: Int
) {
    // 주식 아이템 UI 구현
}