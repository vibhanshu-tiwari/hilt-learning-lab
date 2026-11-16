package com.vibh.hiltlearninglab.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vibh.hiltlearninglab.ui.home.HomeScreen
import com.vibh.hiltlearninglab.ui.home.HomeViewModel

@Composable
fun AppNavigation(
    paddingValues: PaddingValues
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestination.Home.route
    ){
        composable(AppDestination.Home.route){
            val viewModel: HomeViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            HomeScreen(
                uiState = uiState,
                onRefresh = {
                    // later
                },
                onProductClick = { product ->
                    // Navigate later
                }
            )
        }
    }
}