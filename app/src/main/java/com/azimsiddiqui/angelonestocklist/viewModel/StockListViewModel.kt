package com.azimsiddiqui.angelonestocklist.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azimsiddiqui.angelonestocklist.models.Stock
import com.azimsiddiqui.angelonestocklist.repository.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockListViewModel  @Inject constructor(private val repository: StockRepository):
    ViewModel() {

    private val _stockListLiveData= MutableLiveData<List<Stock>>()
    val stockListLiveData: LiveData<List<Stock>>
        get() = _stockListLiveData

    fun getStocks(){
        viewModelScope.launch { Dispatchers.IO
            val result=repository.getStocks()
            if(result.isSuccessful)
                _stockListLiveData.postValue(result.body())
            else
                Log.d("tag", "getStocks Error: ${result.code()}")
        }
    }
}