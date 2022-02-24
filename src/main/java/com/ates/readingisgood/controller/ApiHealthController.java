package com.ates.readingisgood.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/health")
public class ApiHealthController {

    @GetMapping
    public String healtCheck(){
        return "Service is running...";
    }
}
