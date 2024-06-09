package fr.epf.min1.projetpays.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {
    @Query("SELECT * FROM favorite_countries")
    fun getAllFavorites(): LiveData<List<CountryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(country: CountryEntity)

    @Delete
    suspend fun removeFavorite(country: CountryEntity)
}