package com.example.weatherapptesttask.data.remote.api

import com.example.weatherapptesttask.data.common.constants.Constants.API_KEY
import com.example.weatherapptesttask.data.common.constants.Constants.FORECAST_END_POINT
import com.example.weatherapptesttask.data.remote.models.WeatherDataModel


import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitWeatherApi {
    @GET(FORECAST_END_POINT)
    suspend fun getWeatherData(
        @Query("key") key: String = API_KEY,
        @Query("q") q: String,
        @Query("days") days: String = "8",
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no",
        @Query("lang") lang: String = "ru"
    ) : WeatherDataModel
}

