package com.shadrack.weatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shadrack.weatherapp.data.datasource.local.entity.WeatherItem
import com.shadrack.weatherapp.data.datasource.remote.WeatherResponse
import com.shadrack.weatherapp.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.withContext

@HiltViewModel
class WeatherViewModel @Inject constructor (private val weatherRepository: WeatherRepository)
    : ViewModel() {

    private val _weatherItems = MutableLiveData<List<WeatherItem>>()
    val weatherItems : LiveData<List<WeatherItem>> = _weatherItems

    fun getWeatherRemote(q : String, key : String) {

        viewModelScope.launch(Dispatchers.IO) {
            val response = weatherRepository.getWeatherRemote(q, key)

                saveWeatherItem(
                    WeatherItem( 0, response.location.region, response.location.country,
                        response.location.lat,
                        response.location.lon, response.location.localtime)
                )
        }
    }

    fun getWeatherLocal() {

        viewModelScope.launch(Dispatchers.IO) {
            val weatherItemsFromRoomDatabase = weatherRepository.getWeatherItemsLocal()
            withContext(Dispatchers.Main){
                _weatherItems.value = weatherItemsFromRoomDatabase
            }


        }
    }

    fun saveWeatherItem (weatherItem: WeatherItem) {

        viewModelScope.launch(Dispatchers.IO) {
            weatherRepository.saveWeatherItem(weatherItem)
        }
    }

    fun deleteWeatherItem(weatherItem: WeatherItem) {

        viewModelScope.launch {
            weatherRepository.deleteWeatherItem(weatherItem)
        }
    }
}