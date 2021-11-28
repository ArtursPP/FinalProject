package com.finalProject.service;

import com.finalProject.config.ApplicationConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class CountryService {

    private RestTemplate restTemplate;

    public void getCountryInfoByCapitalCity(String capitalCity){
        String userStr = restTemplate.getForObject("https://restcountries.com/v3.1/capital/" + capitalCity, String.class);
        System.out.println(userStr);
    }
}
