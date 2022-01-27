package com.praepost.weather_rest_task.service;

import com.praepost.weather_rest_task.dao.WeatherDAO;
import com.praepost.weather_rest_task.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;

@Service
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private WeatherDAO weatherDAO;

    @Override
    @Transactional
    public void saveWeather(Weather weather) {
        weatherDAO.saveWeather(weather);
    }

    @Override
    @Transactional
    public Weather getWeather(Date currentDate){return  weatherDAO.getWeather(currentDate);}

}
