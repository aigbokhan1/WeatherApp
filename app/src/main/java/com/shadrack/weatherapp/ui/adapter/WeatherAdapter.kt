package com.shadrack.weatherapp.ui.adapter

import android.media.audiofx.NoiseSuppressor.create
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.shadrack.weatherapp.data.datasource.local.entity.WeatherItem
import com.shadrack.weatherapp.ui.viewmodel.WeatherViewModel_HiltModules_KeyModule_ProvideFactory.create

class WeatherAdapter(): ListAdapter<WeatherItem, WeatherViewHolder>(DIFF_CALLBACK){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : WeatherViewHolder {
        return WeatherViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int){
        holder.bind(getItem(position))
    }

    companion object {
        private  val DIFF_CALLBACK = object : DiffUtil.ItemCallback<WeatherItem>(){
            override fun areItemsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean {
                return oldItem.id ==newItem.id
            }

            override fun areContentsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean {
                return oldItem.id == newItem.id
            }
        }

    }
}