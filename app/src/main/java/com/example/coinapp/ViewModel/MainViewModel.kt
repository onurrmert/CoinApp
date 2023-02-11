package com.example.coinapp.ViewModel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinapp.Model.MarketsItem
import com.example.coinapp.Retrofit.RetrofitService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val retrofitService: RetrofitService) : ViewModel() {

    val coinList1 = MutableLiveData<List<MarketsItem>>()

    fun getCoinList(lifecycleOwner: LifecycleOwner){

        viewModelScope.launch {

            retrofitService.getCoinList()

            retrofitService.coinList.observe(lifecycleOwner, Observer {
                coinList1.value = it
            })
        }
    }
}