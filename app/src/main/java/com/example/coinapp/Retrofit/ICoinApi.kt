package com.onurmert.retro4fitt.Retrofit1

import com.example.coinapp.Model.CoinModel
import com.example.coinapp.Util.Contant
import retrofit2.Response
import retrofit2.http.GET

interface ICoinApi {

    @GET(Contant.ApiUrl)
    suspend fun getCoin() : Response<CoinModel>
}