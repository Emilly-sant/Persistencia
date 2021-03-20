package cesar.school.emilly.test.ui.main.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cesar.school.emilly.test.data.remote.RetrofitManager
import cesar.school.emilly.test.data.remote.model.FindResult
import cesar.school.emilly.test.databinding.FragmentSearchBinding
import cesar.school.emilly.test.extension.isInternetAvailable
import cesar.school.emilly.test.extension.toPx
import cesar.school.emilly.test.ui.main.forecast.ForecastActivity
import cesar.school.emilly.test.util.CityModel
import cesar.school.emilly.test.util.MarginItemDecoration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment: Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private val searchAdapter by lazy { SearchAdapter { city ->
        val intent = Intent(this.requireContext(), ForecastActivity::class.java)
        city.apply {
            val cityModel = CityModel(
                    this.id,
                    this.name,
                    this.country.name,
                    this.temp.number,
                    city.weathers[0].icon
            )
            intent.putExtra("cityModel", cityModel)
            startActivity(intent)
        }
    }}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun findCity() {
        if (requireContext().isInternetAvailable()) {
            val call = RetrofitManager.getOpenWeatherService().findCity(
                binding.edtSearch.text.toString(),
                "metric",
                "pt",
                "5fde54966e3e1c8a80e436245bdf9672"
            )

            call.enqueue(object : Callback<FindResult> {
                override fun onResponse(call: Call<FindResult>, response: Response<FindResult>) {
                    if (response.isSuccessful) {
                        searchAdapter.submitList(response.body()?.cities)
                    } else {
                        Log.w(TAG, "onResponse: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<FindResult>, t: Throwable) {
                    Log.e(TAG, "onFailure", t)
                }
            })
        } else {
            Toast.makeText(requireContext(), "No network access", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initUi() {
        binding.rvCities.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter
            addItemDecoration(MarginItemDecoration(16.toPx()))
        }

        binding.btnSearch.setOnClickListener {
            findCity()
        }
    }

    companion object {
        private const val TAG = "SearchFragment"
    }
}