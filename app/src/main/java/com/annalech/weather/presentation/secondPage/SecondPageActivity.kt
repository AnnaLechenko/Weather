package com.annalech.weather.presentation.secondPage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.annalech.weather.R
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
             val temp =  it.currentTemperature.temp_c
            binding.tvTemperature.text =   checkTemperature(temp)
          }
          if (it.location.name == null){
              binding.errorCity.text =  resources.getString(R.string.error)
          }
      })



    }




    private fun checkTemperature(t : Double):String{
        if (t>0){
            return  "+${t.toInt()}C"
        } else {
            return  "${t.toInt()}C"
        }
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