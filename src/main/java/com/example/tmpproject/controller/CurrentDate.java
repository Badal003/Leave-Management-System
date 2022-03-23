package com.example.tmpproject.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

public class CurrentDate {
    public static Date findCurrentDate()
    {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return Date.valueOf(dateObj.format(formatter));
    }
}
