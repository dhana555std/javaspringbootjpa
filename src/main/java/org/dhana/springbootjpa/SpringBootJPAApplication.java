package org.dhana.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"org.dhana.springbootjpa"})
public class SpringBootJPAApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJPAApplication.class, args);
	}
}
