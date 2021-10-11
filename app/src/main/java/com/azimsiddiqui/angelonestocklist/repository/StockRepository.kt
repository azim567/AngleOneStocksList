package com.azimsiddiqui.angelonestocklist.repository

import com.azimsiddiqui.angelonestocklist.ApiService
import javax.inject.Inject

class StockRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getStocks() = apiService.getAllStocks()
}