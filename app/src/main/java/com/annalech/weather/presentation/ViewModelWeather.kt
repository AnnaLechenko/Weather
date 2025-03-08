package com.annalech.weather.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.annalech.weather.data.retrofit.ApiFactory
import com.annalech.weather.data.retrofit.ApiService
import com.annalech.weather.data.retrofit.RepositoryImpl
import com.annalech.weather.data.retrofit.entity.ResponseWeather
import com.annalech.weather.data.retrofit.entity.Weather
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelWeather(application: Application): AndroidViewModel(application) {
    //ЗАИНЖЕКТИТЬ АПИ В РЕСУРСАХ И ПЕРЕДАВАТЬ ВО ВЬЮ ТОЛЬКО РЕПОЗИТОРИЙ
    val apiServ = ApiFactory.apiService


    private val _ld_Weather = MutableLiveData<ResponseWeather>()
    val ld_Weather: LiveData<ResponseWeather>
        get()= _ld_Weather


    init {

            //загрузка из сети : репозиторий --> экземпляр апи сервиса -> запрос
            loadWeather(apiServ)


    }

    private fun loadWeather( apiServ: ApiService){
        viewModelScope.launch {
            try {
              val response = apiServ.getWeather("9a2b4948241d480b9d8203545250603", "Moscow")


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