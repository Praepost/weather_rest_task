package com.praepost.utils;

import com.praepost.entity.Weather;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;

@Component
public class ParseFromYandex {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "https://api.weather.yandex.ru/v2/informers?lat=59&lon=30";

    public ParseFromYandex(){

    }

    public Weather goParse(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Yandex-API-Key", "eac6a4cf-bc38-42da-afc4-a60e7525f090");

        ResponseEntity<String> responseEntity = null;
        responseEntity = restTemplate.exchange(URL, HttpMethod.GET, new HttpEntity(headers)
                , new ParameterizedTypeReference<String>() {
                });

        JSONObject weatherJsonObject = new JSONObject(responseEntity.getBody());

        JSONObject factArray = (JSONObject) weatherJsonObject.get("fact");
        JSONObject forecastArray = (JSONObject) weatherJsonObject.get("forecast");
        Integer temperature = (Integer) factArray.get("temp");
        Integer time = (Integer) forecastArray.get("date_ts");

        return new Weather(new Date(time*1000L), temperature);
    }
}
