package org.dhana.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootJPAApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJPAApplication.class, args);
	}
}
