package com.praepost.service;

import com.praepost.entity.Weather;

import java.sql.Date;

public interface WeatherService {

    public void saveWeather(Weather weather);
    public Weather getWeather(Date currentDate);
}
