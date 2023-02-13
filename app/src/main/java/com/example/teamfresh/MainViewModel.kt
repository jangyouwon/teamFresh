package com.example.teamfresh

import androidx.lifecycle.ViewModel
import com.example.teamfresh.data.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel():ViewModel() {
    private val _uiState = MutableStateFlow(LoginState())
    val uiState:StateFlow<LoginState> = _uiState.asStateFlow()
}