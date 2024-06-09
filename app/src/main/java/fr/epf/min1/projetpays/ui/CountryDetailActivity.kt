package fr.epf.min1.projetpays.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import fr.epf.min1.projetpays.R
import fr.epf.min1.projetpays.database.Country
import fr.epf.min1.projetpays.database.CountryEntity
import fr.epf.min1.projetpays.viewmodel.CountryViewModel
import fr.epf.min1.projetpays.repository.CountryRepository


class CountryDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: CountryViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)
        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)

        val country = intent.getSerializableExtra("country") as Country

        val flagImageView: ImageView = findViewById(R.id.flagImageView)
        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val capitalTextView: TextView = findViewById(R.id.capitalTextView)
        val regionTextView: TextView = findViewById(R.id.regionTextView)
        val subregionTextView: TextView = findViewById(R.id.subregionTextView)
        val populationTextView: TextView = findViewById(R.id.populationTextView)
        val languagesTextView: TextView = findViewById(R.id.languagesTextView)

        Glide.with(this).load(country.flags.png).into(flagImageView)
        nameTextView.text = country.name.official
        capitalTextView.text = country.capital?.joinToString() ?: "N/A"
        regionTextView.text = country.region
        subregionTextView.text = country.subregion
        populationTextView.text = country.population.toString()
        languagesTextView.text = country.languages.values.joinToString()

        val favoriteButton: Button = findViewById(R.id.favoriteButton)
        favoriteButton.setOnClickListener {
            val countryEntity = CountryEntity(
                name = country.name.common,
                flagUrl = country.flags.png,
                capital = country.capital?.joinToString() ?: "N/A",
                region = country.region,
                subregion = country.subregion,
                population = country.population,
                languages = country.languages.values.joinToString()
            )
            viewModel.addFavorite(countryEntity)
            Toast.makeText(this, "${country.name.common} added to favorites", Toast.LENGTH_SHORT).show()
        }
    }
}
