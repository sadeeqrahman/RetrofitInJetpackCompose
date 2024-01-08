package com.sadeeq.encoders.retrofitinjetpackcompose.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sadeeq.encoders.retrofitinjetpackcompose.components.EdPassword
import com.sadeeq.encoders.retrofitinjetpackcompose.components.EdUserName
import com.sadeeq.encoders.retrofitinjetpackcompose.components.LoginButton
import com.sadeeq.encoders.retrofitinjetpackcompose.datastates.DataState
import com.sadeeq.encoders.retrofitinjetpackcompose.models.UserResponse
import com.sadeeq.encoders.retrofitinjetpackcompose.viewmodel.MyViewModel


@Composable
fun LoginScreen(viewModel: MyViewModel = hiltViewModel()) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val tokenResponseState by viewModel.tokenResponse

    when (tokenResponseState) {
        is DataState.Success -> {
            val tokenResponse = (tokenResponseState as DataState.Success<UserResponse>).data

            // Handle the nullable tokenResponse appropriately
            tokenResponse.let {
                // UI code to handle successful login
                // You can now safely use the non-null tokenResponse
            }
        }
        is DataState.Loading -> {
            // UI code for loading state during login

        }
        is DataState.Error -> {
            val error = (tokenResponseState as DataState.Error).exception
            Log.e("RESPONSE_ERROR_EXCEPTION", error.message.toString())
        }
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 150.dp,
                    start = 16.dp,
                    end = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            EdUserName {
                username = it
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            EdPassword({
                password = it
            }) {

            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp,
                    start = 16.dp,
                    end = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            LoginButton(viewModel,username, password) { enteredUsername, enteredPassword ->

            }
        }


    }
}