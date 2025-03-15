package com.annalech.weather.presentation.secondPage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.annalech.weather.R
import com.annalech.weather.databinding.ActivityFirstPageBinding
import com.annalech.weather.databinding.ActivityMainBinding

class SecondPageActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var viewModel: ViewModelWeather
  lateinit var successLoadFragment:SuccessLoadFragment
    private lateinit var progressBar: ProgressBar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressBar = findViewById(R.id.progressBar)
        showLoadBar()

        val cityExtra = intent.getStringExtra(CITY)?: "London"
        viewModel = ViewModelProvider(this, ViewModelFactory(application, cityExtra))
            .get( ViewModelWeather::class.java)



        viewModel.ld_Weather.observe(this) { it ->
            it?.let {
                if (savedInstanceState == null) {
                    successLoadFragment = SuccessLoadFragment().apply {
                       arguments =  Bundle().apply {
                           putParcelable(WEATHER_RESPONSE, it )
                       }
                    }
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, successLoadFragment)
                        .commit()

                    unshowLoadBar()
                }
            }
        }

        viewModel.ld_error.observe(this){error->
            if (error){
                if (savedInstanceState==null){
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,ErrorLoadFragment())
                        .commit()

                   unshowLoadBar()

                }
            }
        }



    }

   private fun showLoadBar(){
      progressBar.visibility = View.VISIBLE
   }
    private fun unshowLoadBar(){
       progressBar.visibility = View.GONE
    }


    companion object{
        const val CITY = "city"
        const val WEATHER_RESPONSE = "weather"

        fun getIntent(context: Context, city:String): Intent {
            val intent = Intent(context, SecondPageActivity::class.java)
            intent.putExtra(CITY, city)
            return intent
        }
    }
}