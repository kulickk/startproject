package dev.kulick.startproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kulick.startproject.aspect.CountedApi;

@RestController
public class CustomController {

    @CountedApi
    @GetMapping("/api/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Привет!");
    }

}