package com.example.weatherapptesttask.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cryptoappminecleanarchitecturev1.presentation.navigation.SetupNavHost
import com.example.weatherapptesttask.data.common.functions.askLocationPermission
import com.example.weatherapptesttask.data.common.functions.openAppSettings
import com.example.weatherapptesttask.presentation.ui.theme.WeatherAppTestTaskTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)

    val activityContext = this

    @SuppressLint("SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            WeatherAppTestTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    // Запоминаем состояние разрешения
                    val locationPermissionState =
                        rememberPermissionState(Manifest.permission.ACCESS_COARSE_LOCATION)
                    activityContext.askLocationPermission()


                    // Проверяем статус Permission и пока не будет предпринято никаких действий никакая Composable не будет запускаться.
                    // Так как при отказе окно появляется дважды и меняется параметр shouldShowRationale, то для каждого UseCase нужно написать последующий алгоритм действий.
                    when (locationPermissionState.status) {
                        PermissionStatus.Denied(shouldShowRationale = false) -> {
                            SetupNavHost(locationPermissionState)
                        }

                        PermissionStatus.Denied(shouldShowRationale = true) -> {
                            SetupNavHost(locationPermissionState)
                        }

                        PermissionStatus.Granted -> {
                            SetupNavHost(locationPermissionState)
                        }

                        else -> {}
                    }

                }
            }
        }
    }
}


// Функция расширения для перевода пользователя на страницу разрешений для приложения



