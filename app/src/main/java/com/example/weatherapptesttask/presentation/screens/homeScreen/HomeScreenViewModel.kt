package com.example.weatherapptesttask.presentation.screens.homeScreen


import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapptesttask.data.common.classes.UploadStatus
import com.example.weatherapptesttask.data.remote.api.RetrofitWeatherApi
import com.example.weatherapptesttask.data.remote.models.ConditionModel
import com.example.weatherapptesttask.data.remote.models.CurrentModel
import com.example.weatherapptesttask.data.remote.models.ForecastDayModel
import com.example.weatherapptesttask.domain.useCases.GetWeatherUseCase
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val weatherApi: RetrofitWeatherApi,
    private val getWeatherUseCase: GetWeatherUseCase,

    ) : ViewModel() {


    private val _weatherDataState = MutableStateFlow<WeatherInfoState>(WeatherInfoState())
    val weatherDataState = _weatherDataState.asStateFlow()


    var gpsLoc by mutableStateOf("Moscow")
        private set

    var currentWeather by mutableStateOf(CurrentModel(condition = ConditionModel()))
        private set

    var listOfForecast by mutableStateOf(emptyList<ForecastDayModel>())
        private set

    var lastShownCity by mutableStateOf("Москва")
        private set

    var lastWeatherUpdateTime by mutableStateOf("")
        private set

    var changeCityClick by mutableStateOf(false)
        private set


    init {
        getWeather(lastShownCity)
    }


    fun changeStateOfChangeCityClick() {
        changeCityClick = !changeCityClick
    }

    fun changeWeatherDataStateToDefault() {
        _weatherDataState.value = WeatherInfoState()
    }


    fun getWeather(city: String) {
        viewModelScope.launch {
            getWeatherUseCase(city = city).collect { result ->
                when (result) {
                    is UploadStatus.Error -> {
                        _weatherDataState.value =
                            WeatherInfoState(
                                error = result.message
                                    ?: "Что-то пошло не так... \n Попробуй повторить"
                            )
                    }

                    is UploadStatus.Loading -> {
                        _weatherDataState.value = WeatherInfoState(isLoading = true)
                    }

                    is UploadStatus.Success -> {
                        currentWeather =
                            result.data?.current ?: CurrentModel(condition = ConditionModel())
                        listOfForecast =
                            result.data?.forecast?.forecastday ?: emptyList<ForecastDayModel>()
                        lastWeatherUpdateTime = result.data?.location?.localtime ?: ""
                        lastShownCity = result.data?.location?.name ?: "Москва"
                        changeCityClick = false
                        changeWeatherDataStateToDefault()
                    }
                }
            }
        }
    }


    @SuppressLint("MissingPermission")
    fun getGps(context: Context) {

        val priority = Priority.PRIORITY_BALANCED_POWER_ACCURACY
        val locationClient = LocationServices.getFusedLocationProviderClient(context)

        viewModelScope.launch {

            locationClient.getCurrentLocation(priority, CancellationTokenSource().token)
                .addOnSuccessListener { location: Location? ->
                    if (location == null) {
                        lastShownCity = "Москва"
                    } else {
                        val lat = location.latitude
                        val lon = location.longitude

                        val geocoder = Geocoder(context, Locale.getDefault())
                        val geocoderRespond = geocoder.getFromLocation(lat, lon, 1)
                        val address = geocoderRespond?.get(0)

                        if (address?.locality != null) {
                            lastShownCity = address.locality.toString()
                            gpsLoc = address.locality.toString()
                        } else {
                            lastShownCity = "Москва"
                            gpsLoc = "Москва"
                        }
                    }
                }

        }
    }




}








