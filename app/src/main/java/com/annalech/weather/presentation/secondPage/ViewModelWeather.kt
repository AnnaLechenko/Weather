package com.annalech.weather.presentation.secondPage

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.annalech.weather.data.retrofit.RepositoryImpl
import com.annalech.weather.data.retrofit.entity.ResponseWeather
import com.annalech.weather.domain.GetWeatherResponse_UseCase
import kotlinx.coroutines.launch

class ViewModelWeather(application: Application,val city:String): AndroidViewModel(application) {

    val repository = RepositoryImpl(application)
    val getWeatherResponse_UC = GetWeatherResponse_UseCase(repository)


    private val _ld_Weather = MutableLiveData<ResponseWeather>()
    val ld_Weather: LiveData<ResponseWeather>
        get()= _ld_Weather

    private val _ld_error = MutableLiveData<Boolean>()
    val ld_error: LiveData<Boolean>
        get()= _ld_error





    init {
            //загрузка из сети : репозиторий --> экземпляр апи сервиса -> запрос
            loadWeather()
    }

    private fun loadWeather(){
      val scope =   viewModelScope.launch {
            try {
              val response =  getWeatherResponse_UC(city)
                //успешная загрузка обьекта из сети Response<Weather>
                if(response.isSuccessful){
                            Log.d("MY_TAG", "pагружен мой обьект в viewModel ${_ld_Weather.toString()}")
                            Log.d("MY_TAG", "Загружен объект в ViewModel: ${response.body()}")

                            _ld_Weather.postValue(response.body())
                             _ld_error.postValue(false)

                    }else{
                    _ld_error.postValue(true)
                    Log.d("MY_TAG", "Ошибка загрузки данных: ${response}")
                    Log.d("MY_TAG", "Ошибка загрузки данных: ${response.errorBody()}")
                }


            }catch (e:Exception){
                _ld_error.postValue(true)
                  Log.d("MY_TAG","ошибка загрузка из сети в инит блоке вью модели")
                Log.d("MY_TAG", "Ошибка загрузки из сети: ${e.message}")
            }
        }

    }



}