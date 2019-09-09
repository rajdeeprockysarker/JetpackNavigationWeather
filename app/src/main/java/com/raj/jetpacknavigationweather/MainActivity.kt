package com.raj.jetpacknavigationweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.raj.kot.NetworkConnection

class MainActivity : AppCompatActivity() {

    var handler: Handler? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        handler= Handler()
//        handler = object : Handler() {
//
//            override fun handleMessage(msg: Message) {
//                //TODO: Handle different types of messages
//                val b : Any? = msg.data["MyWeatherObject"]
//
//                Log.v("tag", "" + b)
//
//
//            }
//
//            override fun getMessageName(message: Message): String {
//                return super.getMessageName(message)
//            }
//        }
//
//
//        NetworkConnection("Kolkata",handler).execute()
        NavigationUI.setupActionBarWithNavController(this,findNavController(R.id.nav_host_fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

}
