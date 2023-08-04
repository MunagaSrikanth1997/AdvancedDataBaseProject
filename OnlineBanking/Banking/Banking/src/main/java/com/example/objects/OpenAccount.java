package com.example.objects;

import java.math.BigDecimal;

public class OpenAccount {

	private String accountName;
	private String accountType;
	private BigDecimal depositAmount;
	private String userId;
	private Boolean isDebitCardRequired;
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Boolean isDebitCardRequired() {
		return isDebitCardRequired;
	}
	public void setIsDebitCardRequired(Boolean isDebitCardRequired) {
		this.isDebitCardRequired = isDebitCardRequired;
	}
	
}
