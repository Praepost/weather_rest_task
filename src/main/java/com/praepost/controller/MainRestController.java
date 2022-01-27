package com.praepost.controller;

import com.praepost.entity.Weather;
import com.praepost.service.WeatherService;
import com.praepost.utils.ParseFromYandex;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.*;

@RestController
public class MainRestController {

    @Autowired
    ParseFromYandex parseFromYandex;

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather() {
        GregorianCalendar currentTime = new GregorianCalendar();

        Date currentDate = new Date(currentTime.getTimeInMillis());

        Weather weatherDB = weatherService.getWeather(currentDate);

        if (weatherDB == null) {
            weatherDB = parseFromYandex.goParse();
            weatherService.saveWeather(weatherDB);
        }

        return new JSONObject().put("temperature", weatherDB.getTemperature()).toString();
    }
}