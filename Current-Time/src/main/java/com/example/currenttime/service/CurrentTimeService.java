package com.example.currenttime.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CurrentTimeService {

    public String get() {
        LocalDateTime localTime = LocalDateTime.now();
        StringBuilder string_lt = new StringBuilder();
        string_lt.append(localTime.getDayOfMonth());
        string_lt.append(".");
        if (localTime.getMonthValue() < 10) {
            string_lt.append("0");
        }
        string_lt.append(localTime.getMonthValue());
        string_lt.append(".");
        string_lt.append(localTime.getYear());

        return string_lt.toString();
    }

}
