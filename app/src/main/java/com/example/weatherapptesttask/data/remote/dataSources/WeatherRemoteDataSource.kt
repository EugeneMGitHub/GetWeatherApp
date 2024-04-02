package com.example.weatherapptesttask.data.remote.dataSources

import com.example.weatherapptesttask.data.remote.api.RetrofitWeatherApi
import com.example.weatherapptesttask.data.remote.models.WeatherDataModel


import javax.inject.Inject



class WeatherRemoteDataSource @Inject constructor(
    private val retrofitWeatherApi: RetrofitWeatherApi
){
    suspend fun getWeatherData(city: String) : WeatherDataModel {
        return retrofitWeatherApi.getWeatherData(q = city)
    }

}




