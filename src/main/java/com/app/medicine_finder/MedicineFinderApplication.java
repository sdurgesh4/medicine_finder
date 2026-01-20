package com.app.medicine_finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MedicineFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineFinderApplication.class, args);
	}

}
