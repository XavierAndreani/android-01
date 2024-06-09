package fr.epf.min1.projetpays.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
data class Country(
    val name: String,
    val capital: String?,
    val region: String,
    val subregion: String,
    val population: Int,
    val flag: String,
    val languages: String
) : Parcelable

