package com.finalProject.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/rest/Auth.svc")

public class AuthController {

    @GetMapping("/{username}/{password}")
    public void auth(@PathVariable String username, @PathVariable String password) {

        if(username.equals("arturs") && password.equals("12345")){

        } else {
            throw new RuntimeException("Not Authorised");
        }
    }

}
