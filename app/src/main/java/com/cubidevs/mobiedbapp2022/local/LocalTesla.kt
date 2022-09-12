package com.cubidevs.mobiedbapp2022.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_tesla")
data class LocalTesla(
    @PrimaryKey @ColumnInfo(name="id") val id: String,
    @ColumnInfo(name="tittle") val title: String?,
    @ColumnInfo(name="author") val author: String?,
    @ColumnInfo(name="urlToImage") val urlToImage: String?,
    @ColumnInfo(name="publishedAt") val publishedAt: String?,
    @ColumnInfo(name="url") val url: String?,
    @ColumnInfo(name="content") val content: String?,
    @ColumnInfo(name="description") val description: String?,


    )