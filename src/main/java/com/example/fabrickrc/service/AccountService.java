package com.example.fabrickrc.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.fabrickrc.bean.MoneyTransferInput;
import com.example.fabrickrc.custom.CustomProperties;

@Service
public class AccountService {

	@Autowired
	private CustomProperties customProperties;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getAccountBalance(Long accountId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", "S2S");
		headers.set("apikey", this.customProperties.getApiKey());
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = this.restTemplate.exchange(
				this.accountsFabrickUrl() + String.valueOf(accountId) + "/balance", 
				HttpMethod.GET, 
				entity, 
				String.class, 
				headers
			);
		return response.getBody();
	}
	
	public String doMoneyTransfer(Long accountId, MoneyTransferInput moneyTransfer) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", "S2S");
		headers.set("apikey", this.customProperties.getApiKey());
		headers.set("X-Time-Zone", "");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<MoneyTransferInput> entity = new HttpEntity<MoneyTransferInput>(moneyTransfer, headers);
		ResponseEntity<String> response = this.restTemplate.exchange(
				this.accountsFabrickUrl() + accountId + "/payments/money-transfers", 
				HttpMethod.POST, 
				entity, 
				String.class, 
				headers
			);
		return response.getBody();
	}
	
	public String getTransactionList(Long accountId, String fromAccountingDate, String toAccountingDate) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", "S2S");
		headers.set("apikey", this.customProperties.getApiKey());
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
