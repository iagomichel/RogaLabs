package br.com.iagomichel.rogalabs.models

import com.google.gson.annotations.SerializedName

data class Post(
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    @SerializedName("body")
    val message: String = ""
)
