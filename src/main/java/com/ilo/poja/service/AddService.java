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
}
