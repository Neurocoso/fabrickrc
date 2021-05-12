package com.example.fabrickrc.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.fabrickrc.bean.MoneyTransferInput;

@RestController
@RequestMapping("/fabricktest/rest/api/v1")
public class AccountController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/accounts/{accountId}")
	public String getAccountBalance(@PathVariable("accountId") Long accountId){
		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", "S2S");
		headers.set("apikey", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = this.restTemplate.exchange(
				this.accountsFabrickUrl() + String.valueOf(accountId) + "/balance", 
				HttpMethod.GET, 
				entity, 
				String.class, 
				headers
			);
		System.out.println(String.format("Response Status: %s", response.getStatusCode().toString()));
		return response.getBody();
	}
	
	@PostMapping("/accounts/{accountId}/payment/moneytransfer")
	public String doMoneyTransfer(@PathVariable("accountId") Long accountId, 
			@RequestBody MoneyTransferInput moneyTransfer) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", "S2S");
		headers.set("apikey", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		headers.set("X-Time-Zone", "Europe/Rome");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<MoneyTransferInput> entity = new HttpEntity<MoneyTransferInput>(moneyTransfer, headers);
		ResponseEntity<String> response = this.restTemplate.exchange(
				this.accountsFabrickUrl()+ String.valueOf(accountId) + "/payment/moneytransfer", 
				HttpMethod.POST, 
				entity, 
				String.class, 
				headers
			);
		return response.getBody();
	}
	
	@GetMapping("/accounts/{accountId}/transactions")
	public String getTransactionList(@PathVariable("accountId") Long accountId, 
			@RequestParam(required = true, name = "fromAccountingDate") String fromAccountingDate,
			@RequestParam(required = true, name = "toAccountingDate") String toAccountingDate) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", "S2S");
		headers.set("apikey", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String queryParams = "fromAccountingDate=" + fromAccountingDate + "&toAccountingDate=" + toAccountingDate;
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = this.restTemplate.exchange(
				this.accountsFabrickUrl() + String.valueOf(accountId) + "/transactions?" + queryParams, 
				HttpMethod.GET, 
				entity, 
				String.class, 
				headers
			);
		return response.getBody();
	}

	private String accountsFabrickUrl() {
		StringBuilder url = new StringBuilder();
		url.append("https://sandbox.platfr.io");
		url.append("/api/gbs/banking/v4.0/accounts/");
		return url.toString();
	}
}
