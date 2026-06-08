package com.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpring {

    @GetMapping("/hello")
    public String hello() {
        return "Hey, i am learning springboot from scratch";
    }
}
