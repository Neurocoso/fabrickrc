package com.example.fabrickrc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.fabrickrc.custom.CustomProperties;
import com.example.fabrickrc.service.AccountService;

@Configuration
public class AccountConfiguration {

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
