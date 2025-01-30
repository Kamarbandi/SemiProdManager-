package com.example.Manufactor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "azadoscode",
            groupId = "groupId"
    )
    void listener(String data) {
        System.out.println("Our Listener recieved: " + data);
    }
}
