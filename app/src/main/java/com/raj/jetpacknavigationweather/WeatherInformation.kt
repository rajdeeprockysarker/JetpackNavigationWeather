package com.raj.jetpacknavigationweather


import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raj.kot.NetworkConnection
import kotlinx.android.synthetic.main.fragment_weather_information.*


class WeatherInformation : Fragment() {

    var handler: Handler? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_information, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handler= Handler()
        handler = object : Handler() {

            override fun handleMessage(msg: Message) {

                //TODO: Handle different types of messages

                val mTemp = msg.data["Temp"]
                val main = msg.data["main"]
                val mmain = msg.data["main"]
                val temp_max = msg.data["temp_max"]
                val temp_min = msg.data["temp_min"]

                val speed = msg.data["speed"]
                val sunrise = msg.data["sunrise"]
                val sunset = msg.data["sunset"]


                Log.v("tag", "" + mTemp)
                txt_temp.text=mTemp.toString()
                txt_weather_main.text=main.toString()
                txt_min_temp.text=temp_min.toString()+" / "+temp_max.toString()
                txt_wind.text=speed.toString()
                txt_sunrise.text=sunrise.toString()
                txt_sunset.text=sunset.toString()




            }

            override fun getMessageName(message: Message): String {
                return super.getMessageName(message)
            }
        }


        NetworkConnection("Kolkata",handler).execute()
    }


}
