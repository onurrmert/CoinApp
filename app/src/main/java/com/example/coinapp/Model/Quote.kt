package com.example.coinapp.Model

import com.google.gson.annotations.SerializedName

data class Quote(@SerializedName("EUR")
                 val eur: EUR,
                 @SerializedName("USD")
                 val usd: USD)