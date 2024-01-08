package com.sadeeq.encoders.retrofitinjetpackcompose.apis

import com.sadeeq.encoders.retrofitinjetpackcompose.models.UserResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    @FormUrlEncoded
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): UserResponse


}
