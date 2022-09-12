package com.cubidevs.mobiedbapp2022.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TeslaDao {

    @Insert
    suspend fun createTesla(tesla: LocalTesla)
    @Query("SELECT * FROM table_tesla")
    suspend fun getTesla():MutableList<LocalTesla>
    @Delete
    suspend fun deleteTesla(localTesla: LocalTesla)
    @Query("SELECT * FROM table_tesla WHERE url LIKE :url")
    suspend fun searchTesla(url:String?):LocalTesla

}