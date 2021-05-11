package com.example.fabrickrc.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionInput {
	
	private Long accountId;
	private String fromAccountingDate;
	private String toAccountingDate;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getFromAccountingDate() {
		return fromAccountingDate;
	}
	public void setFromAccountingDate(String fromAccountingDate) {
		this.fromAccountingDate = fromAccountingDate;
	}
	public String getToAccountingDate() {
		return toAccountingDate;
	}
	public void setToAccountingDate(String toAccountingDate) {
		this.toAccountingDate = toAccountingDate;
	}
	
	
}
