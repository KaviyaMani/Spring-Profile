package com.nila.profiles.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @Value("${default.msg}")
    private String message;

    @Value("${optional.msg}")
    private String optional;

    @GetMapping
    public String greet() {
        return "Hello!!! " + message;
    }

    @GetMapping("/optional")
    public String greetOptional() {
        return "Hello!!! " + optional;
    }
}
