package com.example.objects;

import java.io.Serializable;
import java.util.Date;

public class PaymentCardDetails implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 696556678811680053L;

	private String accountNumber;
	private String cardNumber;
	private Date cardIssuedDate;
	private String CVV;
	private Date cardValidThroughDate;
	private String pin;
	private String availableBalance;
	private String cardType;
	private String userGuid;
	private boolean isCreditCard;
	

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getCardIssuedDate() {
		return cardIssuedDate;
	}

	public void setCardIssuedDate(Date cardIssuedDate) {
		this.cardIssuedDate = cardIssuedDate;
	}

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String cVV) {
		CVV = cVV;
	}

	public Date getCardValidThroughDate() {
		return cardValidThroughDate;
	}

	public void setCardValidThroughDate(Date cardValidThroughDate) {
		this.cardValidThroughDate = cardValidThroughDate;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(String availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}

	public boolean getIsCreditCard() {
		return isCreditCard;
	}

	public void setIsCreditCard(boolean isCreditCard) {
		this.isCreditCard = isCreditCard;
	}

}
