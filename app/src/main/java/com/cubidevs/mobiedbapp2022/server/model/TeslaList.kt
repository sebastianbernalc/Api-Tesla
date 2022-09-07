package com.cubidevs.mobiedbapp2022.server.model


import com.google.gson.annotations.SerializedName

data class TeslaList(
    @SerializedName("articles")
    val articles: List<Article?>? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null
)