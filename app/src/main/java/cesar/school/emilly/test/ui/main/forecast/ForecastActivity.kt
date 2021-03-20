package cesar.school.emilly.test.ui.main.forecast

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cesar.school.emilly.test.databinding.ActivityForecastBinding
import cesar.school.emilly.test.extension.toPx
import cesar.school.emilly.test.util.CityModel
import cesar.school.emilly.test.util.MarginItemDecoration

class ForecastActivity: AppCompatActivity() {

    private lateinit var binding: ActivityForecastBinding
    private val searchAdapter by lazy { ForecastAdapter(this) }
    lateinit var city: CityModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForecastBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }


    private fun initUi(){
        binding.tvtextForecastActivity.text = "Weather in {city.name}, {city.country} "
        binding.tvTempForecastActivity.text = city.id.toString()
        //binding.tvTempUnitForecastActivity.text = citymodel.tempUnit

        binding.rvForecastsActivity.apply {
            layoutManager = LinearLayoutManager(this@ForecastActivity)
            adapter = searchAdapter
            addItemDecoration(MarginItemDecoration(16.toPx()))
        }
        intent.getParcelableExtra<CityModel>("cityModel")?.let {
            city = it
        }
    }

    }