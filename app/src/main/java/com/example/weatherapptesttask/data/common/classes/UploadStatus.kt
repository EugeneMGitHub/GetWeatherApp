package com.example.weatherapptesttask.data.common.classes

sealed class UploadStatus<T> (val data: T? = null, val message: String? = null) {

    class Loading<T>(data: T? = null) : UploadStatus<T>(data)
    class Success<T>(data: T): UploadStatus<T>(data)
    class Error<T>(data: T? = null, message: String) : UploadStatus<T>(data, message)

}