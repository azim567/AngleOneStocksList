package com.azimsiddiqui.angelonestocklist

import com.azimsiddiqui.angelonestocklist.models.Stock
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("stocks-descriptive59bdd75.json")
    suspend fun getAllStocks(): Response<List<Stock>>
}
