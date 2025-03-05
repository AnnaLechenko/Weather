package com.annalech.weather.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.annalech.weather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:ViewModelWeather

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[ViewModelWeather::class.java]



      viewModel.ld_Weather.observe(this, {
          it->
          binding.tvCity.text = "Minsk"
          binding.tvTemperature.text = it.temp.toString()
      })



    }
}