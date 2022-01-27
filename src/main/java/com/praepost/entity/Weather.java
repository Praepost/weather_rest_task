package com.praepost.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "weather_history", schema = "task_db")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "weather_date")
    private Date date;

    @Column(name = "weather_value")
    private int temperature;

    public Weather(){

    }

    public Weather(Date date, int temperature) {
        this.date = date;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", date=" + date +
                ", temperature=" + temperature +
                '}';
    }
}
