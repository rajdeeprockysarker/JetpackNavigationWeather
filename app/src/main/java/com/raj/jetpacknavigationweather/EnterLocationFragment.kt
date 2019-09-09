package com.raj.jetpacknavigationweather


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_enter_location.*

class EnterLocationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enter_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_get_weather.setOnClickListener {

            var bundle=Bundle()
            bundle.putCharSequence("Locatoin",edit_location.text.toString())

            findNavController().navigate(R.id.action_enterLocationFragment2_to_weatherInformation,bundle)
        }
    }



}
