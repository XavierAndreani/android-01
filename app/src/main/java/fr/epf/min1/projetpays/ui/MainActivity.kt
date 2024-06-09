package fr.epf.min1.projetpays.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epf.min1.projetpays.R
import fr.epf.min1.projetpays.ui.theme.ProjetPaysTheme
import fr.epf.min1.projetpays.viewmodel.CountryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        viewModel.allCountries.observe(this, { countries ->
            countries?.let {
                var adapter = CountryAdapter(it) { country ->
                    val intent = Intent(this, CountryDetailActivity::class.java).apply {
                        putExtra("country", country)
                    }
                    startActivity(intent)
                }
                recyclerView.adapter = adapter
            }
        })
        viewModel.fetchAllCountries()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjetPaysTheme {
        Greeting("Android")
    }
}