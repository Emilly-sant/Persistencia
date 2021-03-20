package cesar.school.emilly.test.ui.main.forecast

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cesar.school.emilly.test.R
import cesar.school.emilly.test.data.remote.model.Forecast
import cesar.school.emilly.test.databinding.ItemCityForecastBinding
import cesar.school.emilly.test.ui.main.settings.SettingsPreferencesFragment
import coil.load

class ForecastAdapter(private val context: Context) : ListAdapter<Forecast, ForecastAdapter.ViewHolder>(SearchDiff()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapter.ViewHolder {
        val binding = ItemCityForecastBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForecastAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCityForecastBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(forecast: Forecast) {
            val imgUrl = "http://openweathermap.org/img/wn/${forecast.weathers[0].icon}@4x.png"

            binding.tvTempForecast.text = forecast.temp.number
            binding.tvDescriptionForecast.text = forecast.weathers[0].description
            binding.tvCloudForecast.text = forecast.clouds.all
            binding.tvWindForecast.text = forecast.wind.speed

            binding.tvTempUnit.text = SettingsPreferencesFragment.getTempUnit()

            binding.tvDateForecast.text = forecast.date
            binding.imgWeatherForecast.load(imgUrl) {
                crossfade(true)
                placeholder(R.drawable.ic_weather_placeholder)
            }
        }
    }
    class SearchDiff: DiffUtil.ItemCallback<Forecast>() {

        override fun areItemsTheSame(oldItem: Forecast, newItem: Forecast) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Forecast, newItem: Forecast) = oldItem == newItem

    }

}