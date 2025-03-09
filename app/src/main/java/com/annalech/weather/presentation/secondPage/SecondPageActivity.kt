package com.annalech.weather.presentation.secondPage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.annalech.weather.databinding.ActivityMainBinding

class SecondPageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: ViewModelWeather

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val cityExtra = intent.getStringExtra(CITY)?: "London"

        viewModel = ViewModelProvider(this, ViewModelFactory(application, cityExtra))
            .get( ViewModelWeather::class.java)



      viewModel.ld_Weather.observe(this, {
          it->
          it?.let {
              binding.tvCity.text = it.location.name
              binding.tvTemperature.text = it.currentTemperature.temp_c.toString()
          }
      })



    }


    companion object{
        const val CITY = "city"

        fun getIntent(context: Context, city:String): Intent {
            val intent = Intent(context, SecondPageActivity::class.java)
            intent.putExtra(CITY, city)
            return intent
        }
    }
}