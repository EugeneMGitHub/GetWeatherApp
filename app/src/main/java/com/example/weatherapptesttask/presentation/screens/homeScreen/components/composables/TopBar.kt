package com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapptesttask.presentation.screens.homeScreen.HomeScreenViewModel
import com.example.weatherapptesttask.presentation.ui.theme.LightText
import com.example.weatherapptesttask.presentation.ui.theme.ReemKufi

@Composable
fun TopBar(
    currentLocation: String,
    homeScreenViewModel: HomeScreenViewModel,
    changeCityClickVM: Boolean,
) {

    if (changeCityClickVM == false) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "Ваш город: $currentLocation",
                fontFamily = ReemKufi,
                color = LightText,
                fontSize = 15.sp,
                textAlign = TextAlign.Left
            )

            TextButton(
                onClick = { homeScreenViewModel.changeStateOfChangeCityClick() },
                contentPadding = PaddingValues(start = 0.dp)
            ) {
                Text(
                    text = "Изменить город",
                    fontFamily = ReemKufi,
                    color = LightText,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Left,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    } else {
        InputNewCityUI(
            closeSearchTopBar = { homeScreenViewModel.changeStateOfChangeCityClick() },
            onDoneClick = { homeScreenViewModel.getWeather(it) }
        )
    }

}