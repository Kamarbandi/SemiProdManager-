package com.example.Manufactor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ManufactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufactorApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
//		if you want to see power of kafka, write here loop with a 10 000 000 sending event to our topic ;-)
//		do not forget taking a look in terminal
// 		bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
		return args -> {
			for (int i = 0; i < 100; i++) {
				kafkaTemplate.send("azadoscode", "Hello Azad :-) " + i);
			}
		};
	}

}
