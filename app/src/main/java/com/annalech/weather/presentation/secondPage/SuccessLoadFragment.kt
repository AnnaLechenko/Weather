package com.annalech.weather.presentation.secondPage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.annalech.weather.R
import com.annalech.weather.data.retrofit.entity.ResponseWeather
import com.annalech.weather.databinding.SuccessLoadFragmentBinding

class SuccessLoadFragment  : Fragment(R.layout.success_load_fragment){
    private var binding: SuccessLoadFragmentBinding? = null
    private lateinit var argument: ResponseWeather

///get city
    override fun onCreate(savedInstanceState: Bundle?) {
        requireArguments().getParcelable<ResponseWeather>(WEATHER_RESPONSE)?.let {
            it->
            argument = it
        }
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = SuccessLoadFragmentBinding.bind(view)
        binding?.let {
           it.tvCity.text = argument.location.name
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object{
        const val WEATHER_RESPONSE = "weather"
    }
}