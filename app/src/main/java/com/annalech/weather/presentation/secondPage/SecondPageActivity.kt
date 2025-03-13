package com.annalech.weather.presentation.secondPage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.annalech.weather.R
import com.annalech.weather.databinding.ActivityMainBinding

class SecondPageActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var viewModel: ViewModelWeather


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val cityExtra = intent.getStringExtra(CITY)?: "London"
        viewModel = ViewModelProvider(this, ViewModelFactory(application, cityExtra))
            .get( ViewModelWeather::class.java)



        viewModel.ld_Weather.observe(this, {
                it->
            it?.let {
                if (savedInstanceState==null){
                    val fragment  =if(it.location.name == null){
                        ErrorLoadFragment()
                    } else{
                        SuccessLoadFragment()
                    }
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit()
                }

            }
            //   binding.errorCity.text =  resources.getString(R.string.error)

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