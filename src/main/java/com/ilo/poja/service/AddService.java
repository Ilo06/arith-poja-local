package com.ilo.poja.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@AllArgsConstructor
public class AddService {
    public BigInteger sumTwoPositiveNumbers(BigInteger a, BigInteger b){
        return a.add(b);
    }

    public BigInteger subtractTwoNumbers(BigInteger a, BigInteger b){
        return a.subtract(b);
    }

    public BigInteger multiplyTwoNumbers(BigInteger a, BigInteger b){
        return a.multiply(b);
    }

    public BigInteger divideTwoNumbers(BigInteger a, BigInteger b){
        return a.divide(b);
    }

}
