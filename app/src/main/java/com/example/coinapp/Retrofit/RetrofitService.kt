package com.example.coinapp.Retrofit

import androidx.lifecycle.MutableLiveData
import com.example.coinapp.Model.MarketsItem
import com.onurmert.retro4fitt.Retrofit1.ICoinApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RetrofitService @Inject constructor(private val iCoinApi: ICoinApi) {

    val coinList = MutableLiveData<List<MarketsItem>>()

    fun getCoinList(){
        CoroutineScope(Dispatchers.Main).launch {
            if (iCoinApi.getCoin().isSuccessful){
                if (iCoinApi.getCoin().body() != null){
                    coinList.value = iCoinApi.getCoin().body()!!.markets!!
                }
            }
        }
    }
}