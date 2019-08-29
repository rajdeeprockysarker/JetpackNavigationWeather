package com.raj.jetpacknavigationweather.pojoo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class ReturnWeatherValue(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)