package com.fleet.management.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SecurityController {
    @GetMapping("/login")
    public ResponseEntity<String> loginPage() {
        return ResponseEntity.status(HttpStatus.OK).body("You are logged in");
    }

    @GetMapping("/register")
    public ResponseEntity<String> registerPage() {
        return ResponseEntity.status(HttpStatus.OK).body("You are registered");
    }

    @GetMapping("/index")
    public ResponseEntity<String> homePage() {
        return ResponseEntity.status(HttpStatus.OK).body("Home Page");
    }
    @GetMapping("/accessDenied")
    public ResponseEntity<String> accessDeniedPage() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied");
    }
}
