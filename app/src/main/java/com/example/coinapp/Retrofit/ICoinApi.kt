package com.onurmert.retro4fitt.Retrofit1

import com.example.coinapp.Model.CoinModel
import com.example.coinapp.Util.Contant
import retrofit2.Call
import retrofit2.http.GET

interface ICoinApi {

    @GET(Contant.ApiUrl)
    fun getCoin() : Call<CoinModel>
}