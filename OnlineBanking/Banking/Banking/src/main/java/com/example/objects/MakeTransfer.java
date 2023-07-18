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
	private String isExternalAccountTransfer;
	private String cardNumber;
	private String CVV;
	private String validThroughDate;
	private String nameOnCard;

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

	public String getIsExternalAccountTransfer() {
		return isExternalAccountTransfer;
	}

	public void setIsExternalAccountTransfer(String isExternalAccountTransfer) {
		this.isExternalAccountTransfer = isExternalAccountTransfer;
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

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String cVV) {
		CVV = cVV;
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

}
