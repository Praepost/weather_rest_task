package com.praepost.weather_rest_task.dao;

import com.praepost.weather_rest_task.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

@Repository
public class WeatherDAOImpl implements WeatherDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void saveWeather(Weather weather) {
        Weather newWeather = entityManager.merge(weather);
        weather.setId(newWeather.getId());
    }

    @Override
    public Weather getWeather(Date currentDate) {
        Query query = entityManager.createQuery("from Weather where weather_date =:currentDate" , Weather.class);

        query.setParameter("currentDate", currentDate);
        List<Weather> allWeathers = query.getResultList();

        return allWeathers.stream().findFirst().orElse(null);
    }
}
