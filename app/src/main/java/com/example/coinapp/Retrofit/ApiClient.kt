package com.onurmert.retro4fitt.Retrofit1

import com.example.coinapp.Util.Constant
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient (){

    private fun getRetrofit() : Retrofit{

        val client = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BaseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }

    companion object{
        fun getCoinApi() : ICoinApi{
            return ApiClient().getRetrofit().create(ICoinApi::class.java)
        }
    }
}
