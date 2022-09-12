package com.cubidevs.mobiedbapp2022.local.repository

import com.cubidevs.mobiedbapp2022.MobieDBApp2022
import com.cubidevs.mobiedbapp2022.local.LocalTesla
import com.cubidevs.mobiedbapp2022.local.TeslaDao

class LocalTeslaRespository {

    suspend fun saveTesla(localTesla: LocalTesla) {
        val teslaDao: TeslaDao= MobieDBApp2022.database.TeslaDao()
        teslaDao.createTesla(localTesla)

    }

    suspend fun getTesla()=MobieDBApp2022.database.TeslaDao().getTesla()
    suspend fun deleteTesla(localTesla: LocalTesla) {

        val teslaDao: TeslaDao= MobieDBApp2022.database.TeslaDao()
        teslaDao.deleteTesla(localTesla)
    }

    suspend fun searchTesla(url: String?)=MobieDBApp2022.database.TeslaDao().searchTesla(url)



}