package com.example.fabrickrc.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

	private Long accountId;
	private String iban;
	private String abiCode;
	private String cabCode;
	private String countryCode;
	private String internationalCin;
	private String nationalCin;
	private String account;
	private String alias;
	private String productName;
	private String holderName;
	private String activatedDate;
	private String currency;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getAbiCode() {
		return abiCode;
	}
	public void setAbiCode(String abiCode) {
		this.abiCode = abiCode;
	}
	public String getCabCode() {
		return cabCode;
	}
	public void setCabCode(String cabCode) {
		this.cabCode = cabCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getInternationalCin() {
		return internationalCin;
	}
	public void setInternationalCin(String internationalCin) {
		this.internationalCin = internationalCin;
	}
	public String getNationalCin() {
		return nationalCin;
	}
	public void setNationalCin(String nationalCin) {
		this.nationalCin = nationalCin;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getActivatedDate() {
		return activatedDate;
	}
	public void setActivatedDate(String activatedDate) {
		this.activatedDate = activatedDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		return "Account {accountId=\'" + this.accountId + "\' "
				+ "iban=\'" + this.iban + "\' "
				+ "abiCode=\'" + this.abiCode + "\' "
				+ "cabCode=\'" + this.cabCode + "\' "
				+ "countryCode=\'" + this.countryCode + "\' "
				+ "internationalCin=\'" + this.internationalCin + "\' "
				+ "nationalCin=\'" + this.nationalCin + "\' "
				+ "account=\'" + this.account + "\' "
				+ "alias=\'" + this.alias + "\' "
				+ "productName=\'" + this.productName + "\' "
				+ "holderName=\'" + this.holderName + "\' "
				+ "activatedDate=\'" + this.activatedDate+ "\' "
				+ "currency=\'" + this.currency + "\'}";
	}
}
