package com.example.springBootDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootDemoApplication {
	private static final Logger LOGGER = LogManager.getLogger(SpringBootDemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
		LOGGER.info("INFO MESSAGE");
		LOGGER.debug("DEBUG MESSAGE");
		LOGGER.error("ERROR MESSAGE");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
