package com.example.fabrickrc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fabrickrc.bean.MoneyTransferInput;
import com.example.fabrickrc.service.AccountService;

@RestController
@RequestMapping("/fabricktest/rest/api/v1")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts/{accountId}/balance")
	public String getAccountBalance(@PathVariable("accountId") Long accountId){
		return this.accountService.getAccountBalance(accountId);
	}
	
	@PostMapping("/accounts/{accountId}/payments/moneytransfers")
	public String doMoneyTransfer(@PathVariable("accountId") Long accountId, 
			@RequestBody MoneyTransferInput moneyTransfer) {
		return this.accountService.doMoneyTransfer(accountId, moneyTransfer);
	}
	
	@GetMapping("/accounts/{accountId}/transactions")
	public String getTransactionList(@PathVariable("accountId") Long accountId, 
			@RequestParam(required = true, name = "fromAccountingDate") String fromAccountingDate,
			@RequestParam(required = true, name = "toAccountingDate") String toAccountingDate) {
		return this.accountService.getTransactionList(accountId, fromAccountingDate, toAccountingDate);
	}

}
