package fr.epf.min1.projetpays.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import fr.epf.min1.projetpays.database.Country
import fr.epf.min1.projetpays.database.CountryEntity
import fr.epf.min1.projetpays.repository.CountryRepository
import kotlinx.coroutines.launch
import retrofit2.Response


class CountryViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CountryRepository(application)
    val allCountries = MutableLiveData<List<Country>>()
    val searchResults = MutableLiveData<List<Country>>()
    val favoriteCountries: LiveData<List<CountryEntity>> = repository.getAllFavorites()

    fun fetchAllCountries() {
        viewModelScope.launch {
            val response = repository.getAllCountries()
            if (response.isSuccessful) {
                allCountries.postValue(response.body())
            }
        }
    }

    fun searchCountries(query: String) {
        viewModelScope.launch {
            val response = repository.searchCountries(query)
            if (response.isSuccessful) {
                searchResults.postValue(response.body())
            }
        }
    }

    fun addFavorite(country: CountryEntity) {
        viewModelScope.launch {
            repository.addFavorite(country)
        }
    }

    fun removeFavorite(country: CountryEntity) {
        viewModelScope.launch {
            repository.removeFavorite(country)
        }
    }

    fun fetchFavoriteCountries() {
        // Automatically handled by LiveData observer
    }

}
