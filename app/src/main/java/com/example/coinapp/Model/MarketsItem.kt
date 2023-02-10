package com.example.coinapp.Model

import com.google.gson.annotations.SerializedName

data class MarketsItem(
    @SerializedName("symbol")
    val symbol: String = "",
    @SerializedName("change_24h")
    val changeH: Double = 0.0,
    @SerializedName("quote")
    val quote: Quote,
    @SerializedName("base_asset")
    val baseAsset: String = "",
    @SerializedName("price")
    val price: Double = 0.0,
    @SerializedName("quote_asset")
    val quoteAsset: String = "",
    @SerializedName("updated_at")
    val updated_at : String
)