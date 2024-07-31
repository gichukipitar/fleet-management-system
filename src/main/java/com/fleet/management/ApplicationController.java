package com.fleet.management;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @GetMapping("/index")
    public ResponseEntity<String> goHome(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to the home page.");
    }
    @GetMapping("/hr")
    public ResponseEntity <String> hr(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome HR page.");
    }
    @GetMapping("/fleet")
    public ResponseEntity<String> fleet(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome fleet page.");
    }
    @GetMapping("/accounts")
    public ResponseEntity<String> accounts(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome accounts page.");
    }
    @GetMapping("/payroll")
    public ResponseEntity<String> payroll(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome payroll page.");
    }
    @GetMapping("/helpdesk")
    public ResponseEntity<String> helpdesk(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome helpdesk page.");
    }
    @GetMapping("/parameters")
    public ResponseEntity<String> parameters(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome parameters page.");
    }
    @GetMapping("/reports")
    public ResponseEntity<String> reports(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome reports page.");
    }
    @GetMapping("/security")
        public ResponseEntity<String> security(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome security page.");
        }
}
