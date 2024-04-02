package com.example.cryptoappminecleanarchitecturev1.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.weatherapptesttask.presentation.screens.homeScreen.HomeScreen


import com.example.weatherapptesttask.presentation.screens.homeScreen.HomeScreenViewModel
import com.example.weatherapptesttask.presentation.screens.splashScreen.SplashScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState


@OptIn(ExperimentalPermissionsApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavHost(locationPermissionState: PermissionState) {

    val navController = rememberNavController()
    val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {
        composable(
            route = Routes.HomeScreen.route
        ) {
            HomeScreen(
                locationPermissionState,
                homeScreenViewModel = homeScreenViewModel
            )
        }
        composable(
            route = Routes.SplashScreen.route
        ) {
            SplashScreen(
                navigationAction = { navController.navigate(Routes.HomeScreen.route) }
            )
        }
    }
}