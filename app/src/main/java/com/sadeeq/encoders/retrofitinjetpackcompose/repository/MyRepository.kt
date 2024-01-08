package com.sadeeq.encoders.retrofitinjetpackcompose.repository

import com.sadeeq.encoders.retrofitinjetpackcompose.apis.ApiService
import com.sadeeq.encoders.retrofitinjetpackcompose.datastates.DataState
import com.sadeeq.encoders.retrofitinjetpackcompose.models.UserResponse
import retrofit2.Response
import javax.inject.Inject

class MyRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(username: String, password: String): DataState<UserResponse> {
        return try {
            val tokenResponse = apiService.login(username, password)
            DataState.Success(tokenResponse)
        } catch (e: Exception) {
            DataState.Error(e)
        }
    }
}
