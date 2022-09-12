package com.cubidevs.mobiedbapp2022

import android.app.Application
import androidx.room.Room
import com.cubidevs.mobiedbapp2022.local.TeslaDatabase

class MobieDBApp2022 : Application() {
    companion object {
        lateinit var database: TeslaDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database= Room.databaseBuilder(
            this,
            TeslaDatabase::class.java,
            "tesla_db"
        ).build()
    }

}