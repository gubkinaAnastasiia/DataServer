package com.example.currenttime.controller;

import com.example.currenttime.service.CurrentTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentTimeController {

    private final CurrentTimeService service;

    public CurrentTimeController(CurrentTimeService service) {
        this.service = service;
    }

    @GetMapping("/time")
    public ResponseEntity<String> show_time() {
        String time = service.get();
        return new ResponseEntity(time, HttpStatus.OK);
    }

}