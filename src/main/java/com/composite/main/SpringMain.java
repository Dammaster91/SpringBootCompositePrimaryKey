package com.composite.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.composite.*")
@EntityScan("com.composite.*")
public class SpringMain {
	public static void main(String[] args) {

		SpringApplication.run(SpringMain.class, args);
	}

}