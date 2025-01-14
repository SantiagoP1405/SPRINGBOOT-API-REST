package com.santiagogomez.springbootapi.med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello") //Decirle qqué ruta de http está siguiendo
public class HelloController {
    @GetMapping
    public String hello() {
        return "Hello, Spring Boot!";
    }
}
