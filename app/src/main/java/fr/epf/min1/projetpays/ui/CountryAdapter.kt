package fr.epf.min1.projetpays.ui
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.epf.min1.projetpays.R
import fr.epf.min1.projetpays.database.Country
import fr.epf.min1.projetpays.database.CountryEntity
import com.squareup.picasso.Picasso


class CountryAdapter(private val countries: List<Country>,
                     private val onClick: (Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val flagImageView: ImageView = itemView.findViewById(R.id.flagImageView)
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)

        fun bind(country: Country) {
            nameTextView.text = country.name
            Picasso.get().load(country.flag).into(flagImageView)

            itemView.setOnClickListener {
                onClick(country)
            }
        }
    }
}
