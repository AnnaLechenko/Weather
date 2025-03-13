package com.annalech.weather.presentation.firstPage

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged

import com.annalech.weather.databinding.ActivityFirstPageBinding
import com.annalech.weather.presentation.secondPage.SecondPageActivity


class FirstPageActivity : AppCompatActivity() {
    private lateinit var   binding:ActivityFirstPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.isEnabled = false

        binding.etEditCity.doOnTextChanged { text, _, _, _ ->

            val info = text.toString()
            val city = checkInfo(info)
        }

        binding.button.setOnClickListener {
           val info = binding.etEditCity.text.toString()
            if(info.length< MIN_LENGHT_CITY){
                Toast.makeText(
                    this ,
                    "Название города должно состоять из 2 и более символов",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                startActivity( SecondPageActivity.getIntent(this,info)) //запуск второго окна
            }

        }

    }

    //проверка данных из строки ввода на наличие других символов, кроме латинских
    private fun checkInfo( info:String):String{
         val city = info.trim()
            // Проверяем, что город состоит только из латинских букв
            if(!city.matches("^[a-zA-Z]+$".toRegex())){
                // Если не соответствует условию, показываем тост
                Toast.makeText(this,
                    "Город должен быть написан латиницей и не содержать чисел.",
                    Toast.LENGTH_SHORT).show()
                      binding.button.isEnabled = false
            } else{
                binding.button.isEnabled = true
            }
       return city
    }



    companion object{
        private const val MIN_LENGHT_CITY = 3
    }
}

