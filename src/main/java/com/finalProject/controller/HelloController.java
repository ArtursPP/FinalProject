package com.finalProject.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${myconfig.one}")
    private String config;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World " + config;
    }


}
