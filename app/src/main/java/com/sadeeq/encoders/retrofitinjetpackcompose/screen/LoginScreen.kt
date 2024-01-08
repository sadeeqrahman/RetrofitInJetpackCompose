package com.sadeeq.encoders.retrofitinjetpackcompose.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.sadeeq.encoders.retrofitinjetpackcompose.R
import com.sadeeq.encoders.retrofitinjetpackcompose.datastates.DataState
import com.sadeeq.encoders.retrofitinjetpackcompose.models.NewsResponse
import com.sadeeq.encoders.retrofitinjetpackcompose.viewmodel.MyViewModel


@Composable
fun LoginScreen(viewModel: MyViewModel = hiltViewModel()) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val tokenResponseState by viewModel.newsResponse

    when (tokenResponseState) {
        is DataState.Success -> {
            val tokenResponse = (tokenResponseState as DataState.Success<NewsResponse>).data

            // Handle the nullable tokenResponse appropriately
            tokenResponse.let {
                LazyColumn(
                    modifier = Modifier
                        .background(color = colorResource(id = R.color.white))
                ) {

                    items(tokenResponse.sources!!.size) { index ->
                        Text(text = tokenResponse.sources!![index]!!.description!!)
                    }

                }
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
    viewModel.newsList()


}