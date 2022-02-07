package com.praepost.weather_rest_task.service;

import com.praepost.weather_rest_task.dao.WeatherRepository;
import com.praepost.weather_rest_task.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public void saveWeather(Weather weather) {
        weatherRepository.save(weather);
    }

    @Override
    public Weather getWeather(Date date){
        Weather weather = weatherRepository.findWeatherByDate(date);
        return weather;
    }
}
