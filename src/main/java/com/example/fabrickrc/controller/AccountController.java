package com.example.fabrickrc.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.fabrickrc.bean.AccountOutput;

@RestController
@RequestMapping("/fabricktest/rest/v1")
public class AccountController {

	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/accounts/{accountId}")
	public AccountOutput getAccountBalance(@PathVariable("accountId") Long accountId){
		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", "S2S");
		headers.set("Content-Type", "application/json");
		headers.set("apikey", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<AccountOutput> response = this.restTemplate.exchange(
				this.accountsFabrickUrl() + String.valueOf(accountId), 
				HttpMethod.GET, 
				entity, 
				AccountOutput.class, 
				headers
			);
		System.out.println(String.format("Response Status: %s", response.getStatusCode().toString()));
		return response.getBody();
	}
	
	private String accountsFabrickUrl() {
		StringBuilder url = new StringBuilder();
		url.append("https://sandbox.platfr.io");
		url.append("/api/gbs/banking/v4.0/accounts/");
		return url.toString();
	}
}
