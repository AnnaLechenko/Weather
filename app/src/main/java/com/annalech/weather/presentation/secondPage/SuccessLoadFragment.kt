package com.annalech.weather.presentation.secondPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.annalech.weather.R
import com.annalech.weather.data.retrofit.entity.ResponseWeather
import com.annalech.weather.databinding.SuccessLoadFragmentBinding
import com.annalech.weather.presentation.secondPage.SecondPageActivity.Companion

class SuccessLoadFragment  : Fragment(R.layout.success_load_fragment){
    private var _binding: SuccessLoadFragmentBinding ?= null
    private val binding:  SuccessLoadFragmentBinding
        get() = _binding?: throw RuntimeException("SuccessLoadFragmentBinding is null")
    private lateinit var argument: ResponseWeather

///get city
    override fun onCreate(savedInstanceState: Bundle?) {
    setRetainInstance(true)

        requireArguments().getParcelable<ResponseWeather>(WEATHER_RESPONSE)?.let {
            it->
            argument = it
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SuccessLoadFragmentBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


            val temp = argument.currentTemperature.temp_c.toInt()
            val wind = argument.currentTemperature.wind_kph.toInt()
            val humidity = argument.currentTemperature.humidity

            binding.tvTemperature.text = if(temp  > 0){
                                       "+${temp.toString()}°C"
                                    } else {
                                        "${temp.toString()}°C"
                                    }

            binding.tvCity.text = "${argument.location.country}/${argument.location.name}"
            binding.tvWind.text = "Ветер ${wind.toString()} км/час"
            binding.tvHumidity.text =  "Влажность ${humidity.toString()} %"


       chooseAdvice(temp,wind,humidity)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



private fun chooseAdvice(temp:Int, wind:Int, humidity:Int){
    when {
        temp > 30 && humidity > 50 -> binding.tvAdvice.text = "Аномальная жара.\nСтоит охладиться."
        temp>30 && humidity <50 -> binding.tvAdvice.text = "Сегодня жарко.\nСтоит охладиться."
        temp in 20..30 && humidity < 50 -> binding.tvAdvice.text = "Прекрасная погода для прогулки."
        temp in 16..30 && humidity > 60 -> {
            binding.tvAdvice.text = "Ожидается дождь.\nПрихвати с собой зонт."
            binding.successLoadFr.setBackgroundResource(R.drawable.rain_bg)
        }
        temp in 0..15 && humidity > 60 -> {
            binding.tvAdvice.text = "Ожидается дождь.\nПрихвати с собой зонт."
            binding.successLoadFr.setBackgroundResource(R.drawable.rain_bg)
        }
        temp in 0..15 && wind > 20 -> binding.tvAdvice.text = "Ожидается сильный ветер.\nБудьте осторожны."
        temp in -10..0 && wind > 20 -> {
            binding.tvAdvice.text = "На улице холодный ветер.\nПрихватите с собой теплый шарф."
            binding.successLoadFr.setBackgroundResource(R.drawable.winter_bg)
        }
        temp in -10..0 && humidity > 60 -> {
            binding.tvAdvice.text = "На улице холодно.\nОжидается мокрый снег."
            binding.successLoadFr.setBackgroundResource(R.drawable.winter_bg)
        }
        temp < -10 -> {
            binding.tvAdvice.text = "На улице мороз.\nОставайтесь дома."
            binding.successLoadFr.setBackgroundResource(R.drawable.winter_bg)
        }
        else -> binding.tvAdvice.text = "Хороший день!"
    }
}


    companion object{
        const val WEATHER_RESPONSE = "weather"
        fun newInstanse(response: ResponseWeather): SuccessLoadFragment{
            return SuccessLoadFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(WEATHER_RESPONSE, response )
                }
            }
        }
    }
}