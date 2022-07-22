package com.shadrack.weatherapp.data.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherItem (@PrimaryKey(autoGenerate = true) val id : Int = 0, val region : String,
                        val country : String, val lat : Double, val lon : Double, val localtime: String)