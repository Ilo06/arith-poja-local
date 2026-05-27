package com.ilo.poja.controller;

import com.ilo.poja.service.AddService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@Controller
public class ArithPojaController {

    private final AddService addService;

    public ArithPojaController(AddService addService) {
        this.addService = addService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> sumTwoPositiveNumber(@RequestParam BigInteger a, BigInteger b){
        if (a.signum() < 0 || b.signum() <= 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A and B must be greater than 0");
        }

        return ResponseEntity.ok(addService.sumTwoPositiveNumbers(a ,b));
    }
}
