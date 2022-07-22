package com.shadrack.weatherapp.data.datasource.local.dao

import androidx.room.*
import com.shadrack.weatherapp.data.datasource.local.entity.WeatherItem

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather_table")
    fun getWeatherItemsLocal () : List<WeatherItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveWeatherItem (weatherItem: WeatherItem)

    @Delete
    fun delete(weatherItem: WeatherItem)

}