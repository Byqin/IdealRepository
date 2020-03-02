package com.pmo.pfc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"com.pmo.pfc"})
@EnableConfigurationProperties
public class PfcApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PfcApplication.class, args);
	}
		
}
