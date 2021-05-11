package com.example.fabrickrc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FabrickrcApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabrickrcApplication.class, args);
	}

   @Bean
   public RestTemplate getRestTemplate() {
      return new RestTemplate();
   }
}
