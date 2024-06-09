package com.anotn.antstock.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
internal fun HomeRoute(
    onTopicClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
) {
    HomeScreen(
        onTopicClick = onTopicClick,
        modifier = modifier,
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    onTopicClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = rememberLazyStaggeredGridState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Home") },
            )
        },
        content = {contentPadding ->
            Column(
                modifier = Modifier
                    .padding(contentPadding)
            ) {
                IndexContainer(
                    modifier = Modifier
                        .height(300.dp)
                        .padding(16.dp)
                )
                NewsList(
                    modifier = Modifier
                        .height(300.dp)
                        .padding(16.dp)
                )
            }
        }
    )

}

@Composable
fun IndexContainer(modifier: Modifier = Modifier) {
    val markets = listOf("코스피", "코스닥", "다우존스", "나스닥")
    val indices = listOf("2,500.25", "850.35", "33,500.12", "12,800.75")
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(count = 4) {
            IndexItem(title = markets[it], index = indices[it])

        }
    }
}

@Composable
fun IndexItem(title: String, index: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            fontSize = 20.sp)
        Text(text = index,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            fontSize = 20.sp)
    }
}

@Composable
fun NewsList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(count = 5) { news ->
            NewsItem(news = news)
        }
    }
}

@Composable
fun NewsItem(news: Int) {
    // 뉴스 아이템 컴포저블 구현
}