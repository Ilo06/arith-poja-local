package com.ilo.poja.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@AllArgsConstructor
public class AddService {
    public BigInteger sumTwoPositiveNumbers(BigInteger a, BigInteger b){
        if (a.signum() < 0 || b.signum() < 0 ){
            throw new RuntimeException("a and b cannot be less than 0");
        }
        return a.add(b);
    }

}
