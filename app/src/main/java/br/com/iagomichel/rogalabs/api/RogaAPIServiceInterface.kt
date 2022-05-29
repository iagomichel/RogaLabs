package br.com.iagomichel.rogalabs.api

import br.com.iagomichel.rogalabs.BuildConfig
import br.com.iagomichel.rogalabs.models.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RogaAPIServiceInterface {

    @GET("/posts")
    suspend fun fetchPosts(): List<Post>

    companion object Factory {
        fun create() =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.API_URL)
                .build()
                .create(RogaAPIServiceInterface::class.java)
    }
}
