package com.finalProject.controller;


import com.finalProject.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    private CountryService countryService;

    @Value("${myconfig.one}")
    private String config;

    @Autowired
    public HelloController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/hello")
    public String hello() {
        countryService.getCountryInfoByCapitalCity("Riga");
        return "Hello World " + config;
    }


}
