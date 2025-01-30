package com.example.Manufactor.controller;

import com.example.Manufactor.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createOrderTest() throws Exception {
        var order = new Order();
        order.setDescription("test description");
        order.setStatus("test status");
        order.setStartDate(order.getStartDate());
        order.setEndDate(order.getEndDate());

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/orders/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(order))
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("test description"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("test status"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value(order.getStartDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value(order.getEndDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }
    

//    @Test
//    public void testPolindrom() {
//        var result = orderController.polindrome("ada");
//        Assertions.assertTrue( result);
//    }
//
//    @Test
//    public void testPolindrom_NullPointerException() {
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            orderController.polindrome(null);
//        });
//    }
}
