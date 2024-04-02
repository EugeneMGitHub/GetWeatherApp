package com.example.cryptoappminecleanarchitecturev1.presentation.navigation

sealed class Routes (val route: String){
    object HomeScreen : Routes(route = "home_screen")
    object SplashScreen : Routes(route = "splash_screen")
}