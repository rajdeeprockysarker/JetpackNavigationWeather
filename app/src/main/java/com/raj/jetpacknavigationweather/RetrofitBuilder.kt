package com.raj.jetpacknavigationweather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder{
    var retrofit: Retrofit? = null

// https://api.apixu.com/v1/current.json?key=11ae2179d2274486af175122190309&q=kolkata
    fun getAPI(): RetroInterface {
        val BASE_URL = "https://api.apixu.com/"

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit!!.create<RetroInterface>(RetroInterface::class.java)
    }
}