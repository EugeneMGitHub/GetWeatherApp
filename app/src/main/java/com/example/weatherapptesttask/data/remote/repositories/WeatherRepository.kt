package com.example.weatherapptesttask.data.remote.repositories

import com.example.weatherapptesttask.data.remote.models.WeatherDataModel


interface WeatherRepository {
    suspend fun getWeatherData(city: String): WeatherDataModel
}