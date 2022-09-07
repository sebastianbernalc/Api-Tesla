package com.cubidevs.mobiedbapp2022.server.Teslarepository

import com.cubidevs.mobiedbapp2022.server.TesalB

class TeslaRepository {
    private val apikey="5ea5ce36b19a4d2fb5ec908dee6c9415"


    suspend fun getTesla()=TesalB.retrofit.getTesla(apikey)


    }


