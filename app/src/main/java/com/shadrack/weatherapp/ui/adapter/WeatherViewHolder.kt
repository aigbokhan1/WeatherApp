package com.shadrack.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.shadrack.weatherapp.data.datasource.local.entity.WeatherItem
import com.shadrack.weatherapp.databinding.ItemsWeatherBinding

class WeatherViewHolder(private val binding : ItemsWeatherBinding) :
    RecyclerView.ViewHolder(binding.root){

    fun bind(Item : WeatherItem){
        binding.textviewRegion.text = Item.region
        binding.textviewCountry.text = Item.country
        binding.textviewLat.text = Item.lat.toString()
        binding.textviewLon.text = Item.lon.toString()
        binding.textviewLocaltime.text = Item.localtime
    }

    companion object {
        fun create(parent: ViewGroup) : WeatherViewHolder {
            val weatherListItemsBinding =
                ItemsWeatherBinding.inflate(LayoutInflater.from(parent.context), parent,
                false)
            return WeatherViewHolder(weatherListItemsBinding)
        }
    }


}

