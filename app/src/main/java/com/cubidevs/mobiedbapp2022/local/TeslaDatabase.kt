package com.cubidevs.mobiedbapp2022.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities=[LocalTesla::class], version = 1)
abstract class TeslaDatabase:RoomDatabase() {

    abstract fun TeslaDao():TeslaDao
}