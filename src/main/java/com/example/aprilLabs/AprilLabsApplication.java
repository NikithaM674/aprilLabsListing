package com.example.aprilLabs;

import com.example.aprilLabs.apartmentListing.Listing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class AprilLabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AprilLabsApplication.class, args);
	}



}
