
package com.bookworm.bookwormapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class BookwormApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookwormApiGatewayApplication.class, args);
	}

}
