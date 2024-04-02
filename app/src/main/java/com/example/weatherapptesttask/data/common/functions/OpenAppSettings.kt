package com.example.weatherapptesttask.data.common.functions

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.Settings

// Функция расширения для перевода пользователя на страницу разрешений для приложения
fun Activity.openAppSettings() {
    Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null)
    ).also(::startActivity)
}