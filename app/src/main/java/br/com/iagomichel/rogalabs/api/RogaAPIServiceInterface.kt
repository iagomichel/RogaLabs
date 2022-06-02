package br.com.iagomichel.rogalabs.api

import br.com.iagomichel.rogalabs.BuildConfig
import br.com.iagomichel.rogalabs.models.Post
import br.com.iagomichel.rogalabs.models.PostComment
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RogaAPIServiceInterface {

    @GET("/posts")
    suspend fun fetchPosts(): List<Post>

    @GET("/posts/{post_id}/comments")
    suspend fun fetchDetailPosts(@Path("post_id") postId: Int): List<PostComment>

    companion object Factory {
        fun create() =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.API_URL)
                .build()
                .create(RogaAPIServiceInterface::class.java)
    }
}
