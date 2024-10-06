package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/public")
    public String publicEndpoint() {
        return "This is a public endpoint!";
    }

    @GetMapping("/api/admin")
    public String adminEndpoint() {
        return "This is an admin endpoint!";
    }
}
