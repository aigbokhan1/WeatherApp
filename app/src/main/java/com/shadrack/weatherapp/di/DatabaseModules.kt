package com.shadrack.weatherapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shadrack.weatherapp.data.datasource.local.db.WeatherDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModules {

    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, WeatherDB::class.java, "weather_db").build()

    @Singleton
    @Provides
    fun provideWeatherDao(weatherDB: WeatherDB) = weatherDB.weatherDao()

}