package com.example.weatherapptesttask.presentation.screens.homeScreen

import com.example.weatherapptesttask.data.remote.models.WeatherDataModel


data class WeatherInfoState (
    val isLoading: Boolean = false,
//    val weatherData: WeatherDataModel? = null,
    val error: String = ""
)