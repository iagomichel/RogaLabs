package br.com.iagomichel.rogalabs.api

import br.com.iagomichel.rogalabs.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RogaAPIServiceInterface {

    companion object Factory {
        fun create(): RogaAPIServiceInterface {
            val retrofit =
                Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.API_URL)
                    .build()

            return retrofit.create(RogaAPIServiceInterface::class.java)
        }
    }
}
