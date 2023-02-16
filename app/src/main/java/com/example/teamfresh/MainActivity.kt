package com.example.teamfresh

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.teamfresh.data.LoginRequest
import com.example.teamfresh.data.LoginResponse
import com.example.teamfresh.data.req
import com.example.teamfresh.data.res
import com.example.teamfresh.databinding.ActivityMainBinding
import com.example.teamfresh.network.loginService
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.squareup.moshi.Json
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var test:TextView
    private lateinit var mBinding:ActivityMainBinding

    private val model: MainViewModel by viewModels()
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

            var testLogin = req("appdev","Timf1234")

            loginService.service.loginCheck(testLogin).enqueue(object :retrofit2.Callback<res>{

                override fun onResponse(
                    call: Call<res>,
                    response: Response<res>
                ) {
                    if(response.isSuccessful){
                        Log.d("youwon","success "+response.isSuccessful)
                        changePage()
                    }
                }

                override fun onFailure(call: Call<res>, t: Throwable) {
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