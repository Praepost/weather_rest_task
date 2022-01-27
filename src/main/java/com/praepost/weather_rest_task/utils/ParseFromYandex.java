package com.praepost.weather_rest_task.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.praepost.weather_rest_task.entity.Weather;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Component
public class ParseFromYandex {

    private RestTemplate restTemplate = new RestTemplate();
    private final String URL = "https://api.weather.yandex.ru/v2/informers?lat=59&lon=30";

    public ParseFromYandex(){

    }

    public Weather goParse() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Yandex-API-Key", "eac6a4cf-bc38-42da-afc4-a60e7525f090");

        ResponseEntity<String> responseEntity = null;
        responseEntity = restTemplate.exchange(URL, HttpMethod.GET, new HttpEntity(headers)
                , new ParameterizedTypeReference<String>() {
                });

        ObjectMapper mapper = new ObjectMapper();

        Map weatherJsonObject = mapper.readValue(responseEntity.getBody(), Map.class);

        Map factArray = (Map) weatherJsonObject.get("fact");
        Map forecastArray = (Map) weatherJsonObject.get("forecast");
        Integer temperature = (Integer) factArray.get("temp");
        Integer time = (Integer) forecastArray.get("date_ts");

        return new Weather(new Date(time*1000L), temperature);
    }
}
