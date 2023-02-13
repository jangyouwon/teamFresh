package com.example.teamfresh.network

import com.example.teamfresh.BuildConfig
import com.example.teamfresh.data.LoginRequest
import com.example.teamfresh.data.LoginResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST

interface retrofit_network {
    @POST("v1/signin")
    fun loginCheck(@Body req: LoginRequest): Call<LoginResponse>
}

object  loginService{



    private const val URL = " https://yhapidev.teamfresh.co.kr/"

    private val retrofitLogin = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofitLogin.create(retrofit_network::class.java)
//    retrofitLogin.loginCheck("appdev","Timf1234")
}