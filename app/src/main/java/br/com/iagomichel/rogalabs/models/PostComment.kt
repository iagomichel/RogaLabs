package br.com.iagomichel.rogalabs.models

import com.google.gson.annotations.SerializedName

data class PostComment (
    val name: String = "",
    val email: String = "",
    @SerializedName("body")
    val message: String = ""
)