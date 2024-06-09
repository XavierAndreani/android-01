package fr.epf.min1.projetpays.ui
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.epf.min1.projetpays.R
import fr.epf.min1.projetpays.database.Country
import fr.epf.min1.projetpays.database.CountryEntity

class CountryAdapter(private val countries: List<Country>, private val listener: (Country) -> Unit) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position], listener)
    }

    override fun getItemCount() = countries.size

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val flagImageView: ImageView = itemView.findViewById(R.id.flagImageView)
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)

        fun bind(country: Country, listener: (Country) -> Unit) {
            nameTextView.text = country.name.common
            Glide.with(itemView.context)
                .load(country.flags.png)
                .into(flagImageView)
            itemView.setOnClickListener { listener(country) }
        }
    }
}
