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

    public BigInteger subtractTwoNumbers(BigInteger a, BigInteger b){
        return a.subtract(b);
    }

    public BigInteger multiplyTwoNumbers(BigInteger a, BigInteger b){
        return a.multiply(b);
    }

    public BigInteger divideTwoNumbers(BigInteger a, BigInteger b){
        if (b.signum() == 0 ){
            throw new RuntimeException("Cannot divide by 0");
        }

        return a.divide(b);
    }

}
