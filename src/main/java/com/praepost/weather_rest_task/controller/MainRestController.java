package com.praepost.weather_rest_task.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.praepost.weather_rest_task.entity.Weather;
import com.praepost.weather_rest_task.service.WeatherService;
import com.praepost.weather_rest_task.utils.ParseFromYandex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.GregorianCalendar;

@RestController
public class MainRestController {

    @Autowired
    ParseFromYandex parseFromYandex;

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather() throws JsonProcessingException {
        GregorianCalendar currentTime = new GregorianCalendar();

        Date currentDate = new Date(currentTime.getTimeInMillis());

        Weather weatherDB = weatherService.getWeather(currentDate);

        if (weatherDB == null) {
            weatherDB = parseFromYandex.goParse();
            weatherService.saveWeather(weatherDB);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString("temperature: " + weatherDB.getTemperature());
    }
}