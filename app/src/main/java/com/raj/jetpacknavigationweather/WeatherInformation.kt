package com.raj.jetpacknavigationweather


import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager
import android.widget.Toast
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

        var Location=arguments?.getString("Locatoin").toString()

        handler= Handler()
        handler = object : Handler() {

            override fun handleMessage(msg: Message) {

                //TODO: Handle different types of messages

                val mTemp = msg.data["Temp"]
                val main = msg.data["main"]
                val humidity = msg.data["humidity"]
                val rain = msg.data["rain"]
                val cloud = msg.data["cloud"]
//                val temp_min = msg.data["temp_min"]
//
                val speed = msg.data["speed"]
//                val sunrise = msg.data["sunrise"]
//                val sunset = msg.data["sunset"]
//
//
//                Log.v("tag", "" + mTemp)
                if(mTemp!="null") {
                    txt_temp.text = mTemp?.toString()
                    txt_weather_main.text = main?.toString()
                    txt_humidity.text = humidity?.toString() + " %"
                    txt_wind.text = speed?.toString()
                    txt_rain.text = rain?.toString()
                    txt_cloud.text = cloud?.toString()
//                txt_sunrise.text=sunrise.toString()
//                txt_sunset.text=sunset.toString()
                }
                else {
                    Toast.makeText(context,"No Result found for "+ Location,Toast.LENGTH_LONG).show()

                }



            }

            override fun getMessageName(message: Message): String {
                return super.getMessageName(message)
            }
        }


        txt_location.text=Location.split(' ').joinToString(" ") { it.capitalize() }

        NetworkConnection(Location,handler).execute()
    }




}
