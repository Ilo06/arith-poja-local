package com.ilo.poja.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@AllArgsConstructor
public class SubtractService {
    public BigInteger subtractTwoNumbers(BigInteger a, BigInteger b){
        return a.subtract(b);
    }
}
