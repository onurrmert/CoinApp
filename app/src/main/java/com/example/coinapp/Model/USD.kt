package com.example.coinapp.Model

import com.google.gson.annotations.SerializedName

data class USD(@SerializedName("price")
               val price: Double = 0.0,
               @SerializedName("volume_24h")
               val volumeH: Double = 0.0)