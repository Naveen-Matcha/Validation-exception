package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(description ="product service documentation"))
public class ValidationsUsingExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationsUsingExceptionApplication.class, args);
	}

}
