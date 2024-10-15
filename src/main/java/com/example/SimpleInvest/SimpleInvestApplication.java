package com.example.SimpleInvest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SimpleInvestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleInvestApplication.class, args);
	}

}
