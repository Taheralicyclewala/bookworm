package com.bookworm.bookinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@EnableCircuitBreaker
@EnableFeignClients
public class BookInfoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookInfoApplication.class, args);
	}
}
