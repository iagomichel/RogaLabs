package br.com.iagomichel.rogalabs.api

import br.com.iagomichel.rogalabs.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RogaAPIServiceInterface {

    companion object Factory {
        fun create() =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.API_URL)
                .build()
                .create(RogaAPIServiceInterface::class.java)
    }
}
