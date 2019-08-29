package com.raj.jetpacknavigationweather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder{
    var retrofit: Retrofit? = null


    fun getAPI(): RetroInterface {
        val BASE_URL = "http://samples.openweathermap.org/"

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit!!.create<RetroInterface>(RetroInterface::class.java)
    }
}