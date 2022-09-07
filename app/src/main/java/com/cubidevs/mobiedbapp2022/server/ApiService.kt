package com.cubidevs.mobiedbapp2022.server

import com.cubidevs.mobiedbapp2022.server.model.TeslaList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/everything?q=tesla")
    suspend fun getTesla(@Query("apiKey") apikey: String): TeslaList
}