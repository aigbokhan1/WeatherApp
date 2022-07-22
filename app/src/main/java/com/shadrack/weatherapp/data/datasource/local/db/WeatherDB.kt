package com.shadrack.weatherapp.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shadrack.weatherapp.data.datasource.local.dao.WeatherDao
import com.shadrack.weatherapp.data.datasource.local.entity.WeatherItem

@Database (entities = [WeatherItem ::class], version = 1)
abstract class WeatherDB : RoomDatabase() {

    abstract fun weatherDao () : WeatherDao
}