package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.atmloc.service.AtmLocRestClientService;

@SpringBootApplication
public class AtmLocatorWebApplication implements CommandLineRunner{
	
	@Autowired
	private AtmLocRestClientService atmLocRestClientService;

	public static void main(String[] args) {
		SpringApplication.run(AtmLocatorWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//caching the atm locations on startup
		atmLocRestClientService.getAllAtmLocs();
	}

}
