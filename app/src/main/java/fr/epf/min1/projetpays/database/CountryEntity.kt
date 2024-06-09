package fr.epf.min1.projetpays.database

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "favorite_countries")
data class CountryEntity(
    @PrimaryKey val name: String,
    val flagUrl: String,
    val capital: String?,
    val region: String,
    val subregion: String,
    val population: Int,
    val languages: String
) {
    fun toCountry(): Country {
        return Country(name, capital, region, subregion, population, flagUrl, languages)
    }
}