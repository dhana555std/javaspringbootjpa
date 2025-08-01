package org.dhana.spring.jpa.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class TrainingApplication {
	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}
}
