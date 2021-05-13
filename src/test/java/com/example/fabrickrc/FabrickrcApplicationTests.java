package com.example.fabrickrc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.fabrickrc.service.AccountService;

@SpringBootTest
class FabrickrcApplicationTests {
    
	@Autowired
	private AccountService accountService;
	
	@Test
	void whenAccountBalanceCalled_givenAccountId_thenGetBalance() {
		long accountId = 14537780;
		String response = accountService.getAccountBalance(accountId);
		assert response.contains("\"availableBalance\":113.70");
	}
	
	@Test
	void whenAccountTransaction_givenAccountIdAndDates_thenGetTransactions() {
		long accountId = 14537780;
		String fromAccountingDate = "2019-01-01";
		String toAccountingDate = "2019-12-01";
		String response = accountService.getTransactionList(accountId, fromAccountingDate, toAccountingDate);
		assert response.contains("\"transactionId\":\"282831\"");
	}

}
