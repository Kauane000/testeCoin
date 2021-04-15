package com.example.coincrypto

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApi {

    @GET("v1/assets?")
    fun getAllList(@Query("apiKey") api:String): retrofit2.Call<List<Coin>>
}