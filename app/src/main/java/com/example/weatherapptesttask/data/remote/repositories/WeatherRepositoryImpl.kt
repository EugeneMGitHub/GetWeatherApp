package com.example.weatherapptesttask.data.remote.repositories

import com.example.weatherapptesttask.data.remote.dataSources.WeatherRemoteDataSource
import com.example.weatherapptesttask.data.remote.models.WeatherDataModel


import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherRemoteDataSource: WeatherRemoteDataSource
) : WeatherRepository
{

    override suspend fun getWeatherData(city: String): WeatherDataModel {
       return weatherRemoteDataSource.getWeatherData(city=city)
    }


}