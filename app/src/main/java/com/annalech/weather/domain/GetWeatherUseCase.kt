package com.annalech.weather.domain

class GetWeatherUseCase(val repository: Repository) {
    operator fun invoke(repository: Repository){
        repository.getWeather()
    }
}