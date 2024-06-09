package fr.epf.min1.projetpays.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epf.min1.projetpays.R
import fr.epf.min1.projetpays.viewmodel.CountryViewModel

class FavoriteCountriesActivity : AppCompatActivity() {
    private lateinit var viewModel: CountryViewModel
    private lateinit var adapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_countries)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewFavorites)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        viewModel.favoriteCountries.observe(this) { countries ->
            countries?.let {
                adapter = CountryAdapter(it) { country ->
                    val intent = Intent(this, CountryDetailActivity::class.java).apply {
                        putExtra("country", country)
                    }
                    startActivity(intent)
                }
                recyclerView.adapter = adapter
            }
        }
        viewModel.fetchFavoriteCountries()
    }
}
