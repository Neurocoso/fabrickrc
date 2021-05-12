package com.example.fabrickrc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.fabrickrc.custom.CustomProperties;
import com.example.fabrickrc.service.AccountService;

@SpringBootApplication
public class FabrickrcApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabrickrcApplication.class, args);
	}

   @Bean
   public RestTemplate getRestTemplate() {
      return new RestTemplate();
   }
   
   @Bean
   public CustomProperties getCustomProperties() {
	   return new CustomProperties();
   }
   
   @Bean
   public AccountService getAccountService() {
	   return new AccountService();
   }
}
