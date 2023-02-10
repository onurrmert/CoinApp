package com.example.coinapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinapp.Model.MarketsItem
import com.onurmert.retro4fitt.Retrofit1.ApiClient
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val coinList = MutableLiveData<List<MarketsItem>>()

    fun getCoinList(){

        viewModelScope.launch {
            if (ApiClient.getCoinApi().getCoin().isSuccessful){
                if (ApiClient.getCoinApi().getCoin().body() != null){
                    if (ApiClient.getCoinApi().getCoin().body()!!.markets!!.size > 0){
                        coinList.value = ApiClient.getCoinApi().getCoin().body()!!.markets!!
                    }else{
                        println("list is empty")
                    }
                }else{
                    println("body null")
                }
            }else{
                println("is niot succesful")
            }
        }
    }
}