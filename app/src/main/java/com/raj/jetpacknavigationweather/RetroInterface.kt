package com.raj.jetpacknavigationweather

import com.raj.jetpacknavigationweather.pojoo.ReturnWeatherValue
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface RetroInterface {


    @GET("api/v1/employees")
     fun getResults(): Call<ResponseBody>

    @GET("data/2.5/weather")
    // fun getResultsCityVal(@Query("CityName") CityName: String): Call<ResponseBody>
    fun getResultsCityVal(@Query("q") query: String,@Query("appid") appid: String): Call<ReturnWeatherValue>

    @FormUrlEncoded
    @POST("/api/users")
    fun createuser(
        @Field("name") name: String,
        @Field("job") job: String
    ): Call<ResponseBody>

}