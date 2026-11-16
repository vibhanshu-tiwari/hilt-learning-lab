package com.vibh.hiltlearninglab.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vibh.hiltlearninglab.data.model.Product
import com.vibh.hiltlearninglab.ui.home.component.HomeTopBar
import com.vibh.hiltlearninglab.ui.home.component.ProductCard
import com.vibh.hiltlearninglab.ui.theme.HiltLearningLabTheme

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onRefresh: () -> Unit = {},
    onProductClick: (Product) -> Unit = {}
) {
    Scaffold(
        topBar = {
            HomeTopBar()
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(uiState.products) { product ->

                ProductCard(
                    product = product,
                    onClick = {
                        onProductClick(product)
                    }
                )

            }

        }
    }
}