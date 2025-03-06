package com.annalech.weather.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.annalech.weather.data.retrofit.ApiFactory
import com.annalech.weather.data.retrofit.RepositoryImpl
import com.annalech.weather.data.retrofit.Weather
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelWeather: ViewModel() {
    //ЗАИНЖЕКТИТЬ АПИ В РЕСУРСАХ И ПЕРЕДАВАТЬ ВО ВЬЮ ТОЛЬКО РЕПОЗИТОРИЙ
    val apiServ = ApiFactory.apiService


    private val _ld_Weather = MutableLiveData<Weather>()
    val ld_Weather: LiveData<Weather>
        get()= _ld_Weather


    init {
        //загрузка из сети : репозиторий --> экземпляр апи сервиса -> запрос
        loadWeather()
    }

    private fun loadWeather(){
        viewModelScope.launch {
           apiServ.getWeather().enqueue(object : Callback<Weather> {
                //успешная загрузка обьекта из сети Response<Weather>


                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                    if (response.isSuccessful){
                        Log.d("MY_TAG", "pагружен мой обьект в viewModel ${_ld_Weather.toString()}")
                        _ld_Weather.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                    Log.d("MY_TAG","НЕ получен во вью getWeather Error Response: ${call.toString()} ")
                }
            })
        }
    }
}