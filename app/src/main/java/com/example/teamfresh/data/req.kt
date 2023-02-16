package com.example.teamfresh.data


import com.google.gson.annotations.SerializedName

data class req(
    @SerializedName("userLoginId")
    var userLoginId: String,
    @SerializedName("userLoginPassword")
    var userLoginPassword: String
)