package com.example.fabrickrc;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.fabrickrc.service.AccountService;

@TestConfiguration
public class FabrickApplicationTestConfiguration {

	@Bean
	public AccountService getAccountService() {
		return new AccountService();
	}
}
