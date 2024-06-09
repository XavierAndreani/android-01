package fr.epf.min1.projetpays.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_countries")
data class Country(
    @PrimaryKey val name: Name,
    val flagUrl: String,
    val flags: Flags,
    val capital: List<String>?,
    val region: String,
    val subregion: String,
    val population: Int,
    val languages: Map<String, String>
) : Parcelable