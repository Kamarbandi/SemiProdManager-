package com.example.Manufactor.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.Year;

@SpringBootTest
public class DisccountServiceTest {
    @SpyBean
    DisccountService discountService;

    @Test
    public void testCalculateWithDisccountCode() {
        var discount = discountService.getDiscount(100, "Azad");
        Assertions.assertEquals(50f, discount);
    }

    @Test
    public void testCalculateWithDisccountCodeAndYear2026() {
        Mockito.when(discountService.getCurrentYear()).thenReturn(Year.of(2026));
        var discount = discountService.getDiscount(100, "Jasmin");
        Assertions.assertEquals(50f, discount);
    }

    @Test
    public void testCalculateWithDisccountCodeAndYear2025() {
        Mockito.when(discountService.getCurrentYear()).thenReturn(Year.of(2025));
        var discount = discountService.getDiscount(100, "Jasmin");
        Assertions.assertEquals(0f, discount);
    }
}
