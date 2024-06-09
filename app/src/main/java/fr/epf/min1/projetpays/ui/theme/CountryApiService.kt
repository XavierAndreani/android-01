package fr.epf.min1.projetpays.ui.theme

import fr.epf.min1.projetpays.database.Country
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApiService {
    @GET("v3.1/all")
    suspend fun getAllCountries(): Response<List<Country>>

    @GET("v3.1/name/{name}")
    suspend fun searchCountries(@Path("name") name: String): Response<List<Country>>
}