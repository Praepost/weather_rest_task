package com.praepost.dao;

import com.praepost.entity.Weather;

import java.sql.Date;

public interface WeatherDAO {
    public void saveWeather(Weather weather);
    public Weather getWeather(Date currentDate);


}
