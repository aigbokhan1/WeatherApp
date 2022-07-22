package com.shadrack.weatherapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shadrack.weatherapp.R
import com.shadrack.weatherapp.ui.adapter.WeatherAdapter
import com.shadrack.weatherapp.ui.viewmodel.WeatherViewModel
import com.shadrack.weatherapp.util.Constants.key
import com.shadrack.weatherapp.util.Constants.q
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val weatherViewModel : WeatherViewModel by viewModels()
    private lateinit var weatherAdapter : WeatherAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weatherViewModel.getWeatherRemote(q, key)
        weatherViewModel.getWeatherLocal()
        setUpRecyclerView()
        setUpObservers()

    }

    fun setUpObservers(){
        weatherViewModel.weatherItems.observe(this){
            weatherAdapter.submitList(it)
        }
    }

    fun setUpRecyclerView(){

       findViewById<RecyclerView>(R.id.weather_recyclerview).apply {
           weatherAdapter = WeatherAdapter()
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}