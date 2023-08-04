package com.example.objects;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MakeTransfer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2522646380684694505L;

	private String fromAccount;
	private String toAccount;
	private String externalAccountNumber;
	private String routingNumber;
	private String isExternalAccount;
	private String cardNumber;
	private String cVV;
	private String validThroughDate;
	private String nameOnCard;
	private String userGuid;
	private String userId;
private String paymentType;
	private BigDecimal amount;

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getExternalAccountNumber() {
		return externalAccountNumber;
	}

	public void setExternalAccountNumber(String externalAccountNumber) {
		this.externalAccountNumber = externalAccountNumber;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	
	public String getIsExternalAccount() {
		return isExternalAccount;
	}

	public void setIsExternalAccount(String isExternalAccount) {
		this.isExternalAccount = isExternalAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	
	public String getcVV() {
		return cVV;
	}

	public void setcVV(String cVV) {
		this.cVV = cVV;
	}

	public String getValidThroughDate() {
		return validThroughDate;
	}

	public void setValidThroughDate(String validThroughDate) {
		this.validThroughDate = validThroughDate;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
