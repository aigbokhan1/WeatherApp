package com.shadrack.weatherapp.data.repository

import com.shadrack.weatherapp.data.datasource.local.dao.WeatherDao
import com.shadrack.weatherapp.data.datasource.local.entity.WeatherItem
import com.shadrack.weatherapp.data.datasource.remote.WeatherApiService
import com.shadrack.weatherapp.data.datasource.remote.WeatherResponse
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherDao : WeatherDao, private val weatherApiService: WeatherApiService): WeatherRepository {
    override suspend fun getWeatherItemsLocal(): List<WeatherItem> {
        return weatherDao.getWeatherItemsLocal()
    }

    override suspend fun getWeatherRemote(country : String, apiKey : String): WeatherResponse {
        return weatherApiService.getWeatherRemote(country, apiKey)
    }

    override suspend fun saveWeatherItem(weatherItem: WeatherItem) {
        weatherDao.saveWeatherItem(weatherItem)
    }

    override suspend fun deleteWeatherItem(weatherItem: WeatherItem) {
       weatherDao.delete(weatherItem)
    }

}