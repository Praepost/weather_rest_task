package com.praepost.weather_rest_task.service;


import com.praepost.weather_rest_task.entity.Weather;

import java.sql.Date;

public interface WeatherService {

    public void saveWeather(Weather weather);
    public Weather getWeather(Date date);
}
