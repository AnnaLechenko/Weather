package com.annalech.weather.presentation.firstPage

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.annalech.weather.R
import com.annalech.weather.databinding.ActivityFirstPageBinding

class FirstPageActivity : AppCompatActivity() {
    private lateinit var   binding:ActivityFirstPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }



}