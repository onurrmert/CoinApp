package com.example.coinapp.Util

import android.content.Context
import android.net.ConnectivityManager

class InternetControl {
    companion object{
        fun connectionControl(context: Context) : Boolean{
            val manager =
                context.applicationContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = manager.activeNetworkInfo

            if (networkInfo == null) {
                return false//no connection
            }else{
                return true//yes connection
            }
        }
    }
}