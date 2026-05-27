package com.ilo.poja.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

 @Service
 @AllArgsConstructor
public class DivideService {
    public BigInteger divideTwoNumbers(BigInteger a, BigInteger b){
        if (b.signum() == 0 ){
            throw new RuntimeException("Cannot divide by 0");
        }

        return a.divide(b);
    }


}
