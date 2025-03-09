package com.annalech.weather.presentation.secondPage

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.annalech.weather.data.retrofit.ApiFactory
import com.annalech.weather.data.retrofit.entity.ResponseWeather
import kotlinx.coroutines.launch

class ViewModelWeather(application: Application,val city:String): AndroidViewModel(application) {
    //ЗАИНЖЕКТИТЬ АПИ В РЕСУРСАХ И ПЕРЕДАВАТЬ ВО ВЬЮ ТОЛЬКО РЕПОЗИТОРИЙ
    val apiServ = ApiFactory.apiService


    private val _ld_Weather = MutableLiveData<ResponseWeather>()
    val ld_Weather: LiveData<ResponseWeather>
        get()= _ld_Weather



    init {
            //загрузка из сети : репозиторий --> экземпляр апи сервиса -> запрос
            loadWeather()
    }

    private fun loadWeather(){
      val scope =   viewModelScope.launch {
            try {
              val response = apiServ.getWeather(
                  cityName = city
              )
                //успешная загрузка обьекта из сети Response<Weather>
                if(response.isSuccessful){
                            Log.d("MY_TAG", "pагружен мой обьект в viewModel ${_ld_Weather.toString()}")
                            Log.d("MY_TAG", "Загружен объект в ViewModel: ${response.body()}")

                            _ld_Weather.postValue(response.body())

                    }else{
                    Log.d("MY_TAG", "Ошибка загрузки данных: ${response}")
                    Log.d("MY_TAG", "Ошибка загрузки данных: ${response.errorBody()}")
                }


            }catch (e:Exception){
                  Log.d("MY_TAG","ошибка загрузка из сети в инит блоке вью модели")
                Log.d("MY_TAG", "Ошибка загрузки из сети: ${e.message}")
            }
        }

    }



}