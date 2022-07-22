package com.shadrack.weatherapp.data.repository

import com.shadrack.weatherapp.data.datasource.local.entity.WeatherItem
import com.shadrack.weatherapp.data.datasource.remote.WeatherResponse

interface WeatherRepository {

    suspend fun getWeatherItemsLocal() : List<WeatherItem>

    suspend fun getWeatherRemote(country : String, apiKey : String) : WeatherResponse

    suspend fun saveWeatherItem(weatherItem: WeatherItem)

    suspend fun deleteWeatherItem(weatherItem: WeatherItem)
}