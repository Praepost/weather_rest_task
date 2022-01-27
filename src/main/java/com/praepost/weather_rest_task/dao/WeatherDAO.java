package com.praepost.weather_rest_task.dao;


import com.praepost.weather_rest_task.entity.Weather;

import java.sql.Date;

public interface WeatherDAO {
    public void saveWeather(Weather weather);
    public Weather getWeather(Date currentDate);


}
