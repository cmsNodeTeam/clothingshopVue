package com.dev.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dev.api")
public class VueApplication {
	public static void main(String[] args) {
		SpringApplication.run(VueApplication.class, args);
		System.out.println("");
	}
}
