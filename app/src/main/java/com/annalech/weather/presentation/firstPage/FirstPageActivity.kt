package com.annalech.weather.presentation.firstPage

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.annalech.weather.R
import com.annalech.weather.databinding.ActivityFirstPageBinding
import com.annalech.weather.presentation.secondPage.SecondPageActivity

class FirstPageActivity : AppCompatActivity() {
    private lateinit var   binding:ActivityFirstPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val info = binding.etEditCity.text.toString()
           val city =  checkInfo(info)
           startActivity( SecondPageActivity.getIntent(this, city)) //запуск второго окна
        }

    }


    //добавить проверку на введенные данные и вывести тост если данные не верны можно и во вью но тогда тост через лив дату
    private fun checkInfo( info:String):String{
        //val x = Regex("^[a-zA-Z]+$").find(info,0)
       return info.trim()
    }

}

