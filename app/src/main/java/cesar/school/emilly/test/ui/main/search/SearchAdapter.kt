package cesar.school.emilly.test.ui.main.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cesar.school.emilly.test.R
import cesar.school.emilly.test.data.remote.model.City
import cesar.school.emilly.test.databinding.ItemCityBinding
import cesar.school.emilly.test.ui.main.settings.SettingsPreferencesFragment
import coil.load

class SearchAdapter( private val onClickItem:(City) -> Unit): ListAdapter<City, SearchAdapter.ViewHolder>(SearchDiff()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder( holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }



    inner class ViewHolder(private val binding: ItemCityBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(city: City) {
            val imgUrl = "http://openweathermap.org/img/wn/${city.weathers[0].icon}@4x.png"

            binding.tvTemp.text = city.temp.number
            binding.tvDescription.text = city.weathers[0].description
            binding.tvcloud.text = city.clouds.all
            binding.tvWind.text = city.wind.speed

            binding.tvTempUnit.text = SettingsPreferencesFragment.getTempUnit()

            binding.tvCityName.text = city.name
            binding.tvCountry.text = city.country.name
            binding.imgWeather.load(imgUrl) {
                crossfade(true)
                placeholder(R.drawable.ic_weather_placeholder)
            }
            itemView.setOnClickListener {
                onClickItem(city)
            }
        }

    }


    class SearchDiff: DiffUtil.ItemCallback<City>() {

        override fun areItemsTheSame(oldItem: City, newItem: City) = oldItem == newItem

        override fun areContentsTheSame(oldItem: City, newItem: City) = oldItem == newItem

    }
}