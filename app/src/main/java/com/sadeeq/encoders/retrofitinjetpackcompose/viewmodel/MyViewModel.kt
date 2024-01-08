package com.sadeeq.encoders.retrofitinjetpackcompose.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sadeeq.encoders.retrofitinjetpackcompose.datastates.DataState
import com.sadeeq.encoders.retrofitinjetpackcompose.models.NewsResponse
import com.sadeeq.encoders.retrofitinjetpackcompose.models.UserResponse
import com.sadeeq.encoders.retrofitinjetpackcompose.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {

    private val _newsResponse = mutableStateOf<DataState<NewsResponse>>(DataState.Loading)
    val newsResponse: State<DataState<NewsResponse>> = _newsResponse


    fun newsList() {
        viewModelScope.launch {
            _newsResponse.value = repository.newsList()
        }
    }
}
