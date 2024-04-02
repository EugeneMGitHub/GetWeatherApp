package com.example.weatherapptesttask.presentation.screens.homeScreen

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherapptesttask.data.common.functions.openAppSettings

import com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables.BottomBar
import com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables.CityNameAndLastUpdate
import com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables.CurrentWeatherUI
import com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables.ErrorComposable
import com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables.ForeCastUI
import com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables.LoadingAnimationComposable
import com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables.TopBar
import com.example.weatherapptesttask.presentation.screens.homeScreen.components.functions.showSnackBar
import com.example.weatherapptesttask.presentation.ui.theme.ReemKufi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted

@OptIn(ExperimentalPermissionsApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint(
    "MissingPermission", "SuspiciousIndentation",
    "UnusedMaterial3ScaffoldPaddingParameter"
)

@Composable
fun HomeScreen(
    locationPermissionState: PermissionState,
    homeScreenViewModel: HomeScreenViewModel
) {

    val context = LocalContext.current
    val activity = LocalContext.current as Activity
    val scope = rememberCoroutineScope()

    // Проверяем статус Разрешения Location и предпринимаем соответсвующие действия.
    LaunchedEffect(key1 = Unit) {
        if (locationPermissionState.status.isGranted) {
            homeScreenViewModel.getGps(context)
        } else {
            homeScreenViewModel.getWeather("Москва")
        }
    }


    val gpsLoc = homeScreenViewModel.gpsLoc   // Получаем город по Gps
    val lastShownCity = homeScreenViewModel.lastShownCity     // Последний город , который был показан. Нужно для обновления экрана
    val forecastList = homeScreenViewModel.listOfForecast.drop(1)      // Список данных с прогнозом погоды на 7 дней вперед
    val currentWeather = homeScreenViewModel.currentWeather     // Данные о текущей погоде
    val lastWeatherUpdateTime = homeScreenViewModel.lastWeatherUpdateTime   // Данные о времени последнего обновления погоды на сервере
    val weatherDataState = homeScreenViewModel.weatherDataState.collectAsState().value  // Данные об состоянии ответа сервера
    // Параметр нужен для определения типа ошибки. Если этот параметр изменился на true, то ошибка вызвана неправельным вводом названия города
    val changeCityClickVM = homeScreenViewModel.changeCityClick

    val snackbarHostState = remember { SnackbarHostState() }

    // The content of your composable
    Scaffold(snackbarHost = {
        SnackbarHost(snackbarHostState)
    }) {

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            TopBar(lastShownCity, homeScreenViewModel, changeCityClickVM)
            CityNameAndLastUpdate(lastShownCity, lastWeatherUpdateTime)
            CurrentWeatherUI(currentWeatherData = currentWeather)
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Прогноз погоды на ближайшую неделю:",
                fontFamily = ReemKufi,
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
                textAlign = TextAlign.Center
            )
            ForeCastUI(forecastData = forecastList)

            Spacer(modifier = Modifier.weight(1f))

            BottomBar(
                onRefreshClick = { homeScreenViewModel.getWeather(lastShownCity) },
                // Обрабатывается ситуация, когда разрешения Location нет, а пользоветель нажимает на кнопку "Получить текущее расположение"
                onGetCurentLocationClick = {
                    if (locationPermissionState.status.isGranted) {
                        homeScreenViewModel.getWeather(gpsLoc)
                    } else {
                        showSnackBar(
                            snackbarHostState,
                            scope,
                            onButtonClick = {
                                activity.openAppSettings()
                            })
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 30.dp)
            )
        }


        /**В случае долгой загрузки данных или возникновения ошибки эти Composables заполняет экран и выводит соответсвующее отображение загрузки/сообщение */

        LoadingAnimationComposable(
            weatherDataState
        )

        ErrorComposable(
            homeScreenViewModel,
            weatherDataState,
            changeCityClickVM,
            lastShownCity
        )

    }


}






