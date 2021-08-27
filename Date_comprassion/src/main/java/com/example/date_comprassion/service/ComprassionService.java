package com.example.date_comprassion.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class ComprassionService {

    private String givenTime = "01.01.2000";

    public String getGivenTime() {
        return givenTime;
    }

    public void setGivenTime(String givenTime) {
        this.givenTime = givenTime;
    }

    public String comprassion(String givenDate) {

        LocalDateTime localTime = LocalDateTime.now();
        int[] array_givenDate = Arrays.stream(givenDate.split("\\.")).mapToInt(Integer::parseInt).toArray();

        String result;
        if (givenDate!=null) {
            if (localTime.getYear() < array_givenDate[2]) {
                result = "this date in the future";
            } else if (localTime.getYear() > array_givenDate[2]) {
                result = "this date is in the past";
            } else {
                if (localTime.getMonthValue() < array_givenDate[1]) {
                    result = "this date in the future";
                } else if (localTime.getMonthValue() > array_givenDate[1]) {
                    result = "this date is in the past";
                } else {
                    if (localTime.getDayOfMonth() < array_givenDate[0]) {
                        result = "this date in the future";
                    } else if (localTime.getDayOfMonth() > array_givenDate[0]) {
                        result = "this date is in the past";
                    } else {
                        result = "given date today";
                    }
                }
            }
        } else {
            result = "date not specified";
        }
        return result;
    }

}
