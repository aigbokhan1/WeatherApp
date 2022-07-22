package com.shadrack.weatherapp.data.datasource.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("current.json")
    suspend fun getWeatherRemote(@Query("q") q : String,
                                 @Query("key") key : String): WeatherResponse


}