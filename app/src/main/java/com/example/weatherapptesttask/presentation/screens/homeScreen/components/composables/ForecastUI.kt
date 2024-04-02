package com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.weatherapptesttask.data.remote.models.ForecastDayModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForeCastUI(forecastData: List<ForecastDayModel>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(forecastData){item ->
            ForecastCardUI(
                date = item.date,
                temperature = item.day.avgtemp_c,
                condition = item.day.condition.text,
                pictureUrl = item.day.condition.icon,
                humidity = item.day.avghumidity.toString(),
                wind = "${item.day.maxwind_kph} км/ч",
            )
        }
    }



}