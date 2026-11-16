package com.vibh.hiltlearninglab.ui.home.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
    CenterAlignedTopAppBar(
        title = {

            Text(
                text = "Product Catalog",
                style = MaterialTheme.typography.titleLarge
            )

        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Inventory2,
                contentDescription = null
            )
        }
    )
}