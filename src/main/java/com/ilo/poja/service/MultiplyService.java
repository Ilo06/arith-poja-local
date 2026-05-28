package com.ilo.poja.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@AllArgsConstructor
public class MultiplyService {
    public BigInteger multiplyTwoNumbers(BigInteger a, BigInteger b) {
        if (a == null || b == null) throw new IllegalArgumentException("a and b cannot be null");
        return a.multiply(b);
    }
}
