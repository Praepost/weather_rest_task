package com.praepost.weather_rest_task.dao;


import com.praepost.weather_rest_task.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    public Weather findWeatherByDate(Date date);
}
