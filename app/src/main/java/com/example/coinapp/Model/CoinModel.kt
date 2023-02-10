package com.example.coinapp.Model

import com.google.gson.annotations.SerializedName

data class CoinModel(
    @SerializedName("markets")
    val markets: List<MarketsItem>?
)