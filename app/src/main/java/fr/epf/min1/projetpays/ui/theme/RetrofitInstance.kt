package fr.epf.min1.projetpays.ui.theme

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import fr.epf.min1.projetpays.ui.theme.CountryApiService

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://restcountries.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: CountryApiService by lazy {
        retrofit.create(CountryApiService::class.java)
    }
}