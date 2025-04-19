package com.ladakh.databanking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    @GetMapping("/LoginForm")
    public String testRoute() {
        return "Spring Boot is handling this route.";
    }
}
