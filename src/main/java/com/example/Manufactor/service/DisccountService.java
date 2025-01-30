package com.example.Manufactor.service;

import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class DisccountService {

    public float getDiscount(float amount, String discountType) {
        if(discountType.equals("Azad")) {
            return 0.5f * amount;
        } else if (discountType.equals("Jasmin") && getCurrentYear().getValue() == 2026) {
            return 0.5f * amount;
        }

        return 0;
    }

    Year getCurrentYear() {
        return Year.now();
    }
}
