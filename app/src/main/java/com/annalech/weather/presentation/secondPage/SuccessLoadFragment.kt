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
            val temperature = argument.currentTemperature.temp_c.toInt()
            val wind = argument.currentTemperature.wind_kph.toInt()
            val humidity = argument.currentTemperature.humidity

            it.tvTemperature.text = if(temperature > 0){
                                       "+${temperature.toString()}°C"
                                    } else {
                                        "${temperature.toString()}°C"
                                    }

            it.tvCity.text = "${argument.location.country}/${argument.location.name}"
            it.tvWind.text = "Ветер ${wind.toString()} км/час"
            it.tvHumidity.text =  "Влажность ${humidity.toString()} %"
            chooseAdvice(temperature, wind, humidity)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


    private fun chooseAdvice(temp: Int, wind:Int, humdidity: Int){
       binding?.let {
           if (temp>30 && humdidity>50){
                it.tvAdvice.text = "Аномальная жара.\nСтоит охладиться."
           }
           if (temp > 20 && temp < 30 && humdidity<50){
               it.tvAdvice.text = "Прексрасная погода для прогулки."
           }
           if (temp > 16 && temp < 30 && humdidity>60){
               it.tvAdvice.text = "Ожидается дождь.\nПрихвати с собой зонт."
               it.successLoadFr.setBackgroundResource(R.drawable.rain_bg)
           }
           if (temp > 0 && temp < 15 && humdidity>60 ){
               it.tvAdvice.text = "Ожидается дождь.\nПрихвати с собой зонт."
               it.successLoadFr.setBackgroundResource(R.drawable.rain_bg)
           }
           if (temp > 0 && temp < 15 && wind>20 ){
               it.tvAdvice.text = "Ожидается сильный ветер.\nБудьте осторожны."
           }
           if (temp < 0 && temp >-10 && wind>20 ){
               it.tvAdvice.text = "На улице холодный ветер.\nПрихватите с собой теплый шарф."
               it.successLoadFr.setBackgroundResource(R.drawable.winter_bg)
           }
           if (temp < 0 && temp >-10  && humdidity>50 ){
               it.tvAdvice.text = "Ожидается мокрый снег"
               it.successLoadFr.setBackgroundResource(R.drawable.winter_bg)
           }
           if (temp<-10){
               it.tvAdvice.text = "На улице мороз.\nПрихватите термос горячего чаю"
               it.successLoadFr.setBackgroundResource(R.drawable.winter_bg)
           }
           if (temp<-20){
               it.tvAdvice.text = "На улице мороз.\nОставайтесь дома."
               it.successLoadFr.setBackgroundResource(R.drawable.winter_bg)
           }
           if (temp == 0  && humdidity>50 ){
               it.tvAdvice.text = "Ожидается мокрый снег"
               it.successLoadFr.setBackgroundResource(R.drawable.winter_bg)
           }
           else{
               it.tvAdvice.text = "Хороший день!"
           }
       }

    }

    companion object{
        const val WEATHER_RESPONSE = "weather"


    }
}