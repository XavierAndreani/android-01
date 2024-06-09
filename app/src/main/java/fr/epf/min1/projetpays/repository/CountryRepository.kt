package fr.epf.min1.projetpays.repository

import android.app.Application
import fr.epf.min1.projetpays.database.CountryDatabase
import fr.epf.min1.projetpays.database.Country
import fr.epf.min1.projetpays.database.CountryEntity
import fr.epf.min1.projetpays.ui.theme.RetrofitInstance
import retrofit2.Response

class CountryRepository(application: Application) {
    private val api = RetrofitInstance.api
    private val countryDao = CountryDatabase.getDatabase(application).countryDao()

    suspend fun getAllCountries() = api.getAllCountries()
    suspend fun searchCountries(name: String) = api.searchCountries(name)

    fun getAllFavorites() = countryDao.getAllFavorites()
    suspend fun addFavorite(country: CountryEntity) = countryDao.addFavorite(country)
    suspend fun removeFavorite(country: CountryEntity) = countryDao.removeFavorite(country)

}