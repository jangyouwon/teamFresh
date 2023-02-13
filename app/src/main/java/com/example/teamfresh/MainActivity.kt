package com.example.teamfresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.teamfresh.data.LoginRequest
import com.example.teamfresh.data.LoginResponse
import com.example.teamfresh.databinding.ActivityMainBinding
import com.example.teamfresh.network.loginService

import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var test:TextView
    private lateinit var mBinding:ActivityMainBinding
    private val model:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.lifecycleOwner = this
        mBinding.mainViewModel = model
        test = mBinding.loginBtn

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                model.uiState.collect{
                    uiState->
                    if(uiState.isLogIn){
                        changePage()
                    }
                }
            }
        }

    }

    override fun onStart() {
        super.onStart()

        test.setOnClickListener {




            var testLogin = LoginRequest("appdev","Timf1234")
            Log.i("youwon", testLogin.toString())
            loginService.service.loginCheck(testLogin).enqueue(object :retrofit2.Callback<LoginResponse>{
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    Log.d("youwon","success "+response)
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.d("youwon","fail")
                }
            })
        }
    }


    fun changePage(){
        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }
}