package com.praepost.controller;

import java.util.Date;
import java.util.GregorianCalendar;

public class fref {

    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTimeInMillis(1643284800*1000L);

        System.out.println(calendar.getTime());

        Date date = new Date();

        date.setTime(1643230800*1000L);

        System.out.println(date);
    }
}
