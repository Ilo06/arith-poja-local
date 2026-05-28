package com.ilo.poja.controller;

import com.ilo.poja.service.AddService;
import com.ilo.poja.service.DivideService;
import com.ilo.poja.service.MultiplyService;
import com.ilo.poja.service.SubtractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@Controller
public class ArithPojaController {

    private final AddService addService;
    private final SubtractService subtractService;
    private final MultiplyService multiplyService;
    private final DivideService divideService;

    public ArithPojaController(AddService addService, SubtractService subtractService, MultiplyService multiplyService, DivideService divideService) {
        this.addService = addService;
        this.subtractService = subtractService;
        this.multiplyService = multiplyService;
        this.divideService = divideService;
    }



    @PostMapping("/add")
    public ResponseEntity<?> sumTwoPositiveNumber(@RequestParam BigInteger a, @RequestParam BigInteger b) {
        if (a.signum() < 0 || b.signum() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A and B must be greater than 0");
        }
        return ResponseEntity.ok(addService.sumTwoPositiveNumbers(a, b));
    }

    @PostMapping("/minus")
    public ResponseEntity<?> subtractTwoNumber(@RequestParam BigInteger a, @RequestParam BigInteger b) {
        return ResponseEntity.ok(subtractService.subtractTwoNumbers(a, b));
    }

    @PostMapping("/multiply")
    public ResponseEntity<?> multiplyTwoNumber(@RequestParam BigInteger a, @RequestParam BigInteger b) {
        return ResponseEntity.ok(multiplyService.multiplyTwoNumbers(a, b));
    }

    @PostMapping("/divide")
    public ResponseEntity<?> divideTwoNumbers(@RequestParam BigInteger a, @RequestParam BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot Divide by 0");
        }
        return ResponseEntity.ok(divideService.divideTwoNumbers(a, b));
    }
}
