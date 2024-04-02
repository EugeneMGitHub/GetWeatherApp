package com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapptesttask.data.remote.models.LocalModel
import com.example.weatherapptesttask.presentation.ui.theme.Poppins


@Composable
fun CityNameAndLastUpdate(city:String, lastWeatherUpdateTime: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        
        Text(
            text = city,
            fontFamily = Poppins,
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.DarkGray,
            modifier = Modifier.padding(top = 20.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Последнее обновление:",
            fontFamily = Poppins,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.LightGray,
            modifier = Modifier.padding(top = 0.dp)
        )
        Text(
            text = lastWeatherUpdateTime,
            fontFamily = Poppins,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.LightGray,
            modifier = Modifier.padding(top = 0.dp)
        )
    }
}