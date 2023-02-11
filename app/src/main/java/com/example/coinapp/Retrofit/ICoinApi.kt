package com.onurmert.retro4fitt.Retrofit1

import com.example.coinapp.Model.CoinModel
import com.example.coinapp.Util.Constant
import retrofit2.Response
import retrofit2.http.GET

interface ICoinApi {

    @GET(Constant.ApiUrl)
    suspend fun getCoin() : Response<CoinModel>
}