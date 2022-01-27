package com.praepost.dao;

import com.praepost.entity.Weather;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class WeatherDAOImpl implements WeatherDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveWeather(Weather weather) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(weather);
    }

    @Override
    public Weather getWeather(Date currentDate) {
        Session session = sessionFactory.getCurrentSession();

        Query<Weather> query = session.createQuery("from Weather where weather_date =:currentDate" , Weather.class);
        query.setParameter("currentDate", currentDate);
        List<Weather> allWeathers = query.getResultList();

        return allWeathers.stream().findFirst().orElse(null);
    }
}
