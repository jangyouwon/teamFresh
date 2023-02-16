package com.example.teamfresh

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.teamfresh.data.LoginState
import kotlinx.android.synthetic.main.activity_home.view.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(application: Application):AndroidViewModel(application) {
    val context:Context = application.applicationContext
    private val _uiState = MutableStateFlow(LoginState())
    val uiState:StateFlow<LoginState> = _uiState.asStateFlow()



    fun clickToast(view: View){
        Log.i("youwon", view.id.toString())
        Toast.makeText(context,"toast", Toast.LENGTH_SHORT).show()
    }

}