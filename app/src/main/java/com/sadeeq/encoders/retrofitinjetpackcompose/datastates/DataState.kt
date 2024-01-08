package com.sadeeq.encoders.retrofitinjetpackcompose.datastates

sealed class DataState<out T : Any> {
    data class Success<out T : Any>(val data: T) : DataState<T>()
    object Loading : DataState<Nothing>()
    data class Error(val exception: Exception) : DataState<Nothing>()
}

