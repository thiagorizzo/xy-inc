package com.poiproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class PoiProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(PoiProjectApplication.class);

	public static void main(String[] args) {
		final ApplicationContext applicationContext = SpringApplication.run(PoiProjectApplication.class, args);
		SpringApplication.run(PoiProjectApplication.class, args);
	}
}
