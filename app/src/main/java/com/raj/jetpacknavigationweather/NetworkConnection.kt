package com.raj.kot

import android.os.*
import android.util.Log
import com.raj.jetpacknavigationweather.RetrofitBuilder
import com.raj.jetpacknavigationweather.pojoo.ReturnWeatherValue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NetworkConnection(CityName:String,handler: Handler?) : AsyncTask<Void, Void, Void>() {

    var getCardService: RetrofitBuilder? = null
    var CityName:String=CityName
    var handler: Handler? =handler

    override fun doInBackground(vararg voids: Void): Void? {

        ///////////////////// GET ////////////////////////////
        val msg = Message()


        if (this.getCardService == null) {
            this.getCardService = RetrofitBuilder()
        }

        getCardService!!
            .getAPI()
            //.getResultsCityVal(CityName)
            .getResultsCityVal("11ae2179d2274486af175122190309","Kolkata")
            .enqueue(object : Callback<ReturnWeatherValue> {
                override fun onResponse(call: Call<ReturnWeatherValue>, response: Response<ReturnWeatherValue>) {
                    Log.e("post", response.message())



                    var message=Message()

                    var bundle=Bundle()
                    bundle.putCharSequence("Temp", response.body()?.current?.temp_c.toString())
                    bundle.putCharSequence("main",     response.body()?.current?.condition?.text )

                    bundle.putCharSequence("humidity", response.body()?.current?.humidity.toString())
                    bundle.putCharSequence("rain", response.body()?.current?.precip_mm.toString()+" mm")

                    bundle.putCharSequence("cloud", response.body()?.current?.cloud.toString()+ " %")


//                    bundle.putCharSequence("temp_max", response.body()?.main?.temp_max.toString())
//                    bundle.putCharSequence("temp_min", response.body()?.main?.temp_min.toString())
//
                    bundle.putCharSequence("speed",  response.body()?.current?.wind_kph.toString()+" kmph")
//                    bundle.putCharSequence("sunrise", response.body()?.sys?.sunrise.toString())
//                    bundle.putCharSequence("sunset", response.body()?.sys?.sunset.toString())
//
//
//
                    message.data=bundle

                    handler?.sendMessage(message)

                }

                override fun onFailure(call: Call<ReturnWeatherValue>, t: Throwable) {
                    Log.v("post", "Val")
                }
            })
        //////////////////// GET END///////////////////////////////


        /////////////////// POST /////////////////////////

        //            if (this.postCardService == null) {
        //                this.postCardService = new POSTCardService();
        //            }
        //
        //            postCardService
        //                    .getAPI()
        //                    .createuser("raj", "consul")
        //                    .enqueue(new Callback<ResponseBody>() {
        //                        @Override
        //                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        //                            Log.v("post","Val");
        //                        }
        //
        //                        @Override
        //                        public void onFailure(Call<ResponseBody> call, Throwable t) {
        //                            Log.v("post","Val");
        //                        }
        //                    });

        /////////////////// POST END /////////////////////////


        return null
    }

}