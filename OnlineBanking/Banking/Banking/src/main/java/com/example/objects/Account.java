package com.example.objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2923987240793904280L;

	
	@Id 
	private ObjectId _id;
	private String accountName;
	private String accountType;
	private String accountNumber;
	private String userGuid;
	private BigDecimal availableBlance;
	private boolean isDebitCardAvailable;
	private String cINNumber;
	private String accountStatus;
	private Date accountOpenedData;
	private String routingNumber;
	private List<PaymentCardDetails> cardsList=new ArrayList();

	

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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}

	public BigDecimal getAvailableBlance() {
		return availableBlance;
	}

	public void setAvailableBlance(BigDecimal availableBlance) {
		this.availableBlance = availableBlance;
	}

	public boolean isDebitCardAvailable() {
		return isDebitCardAvailable;
	}

	public void setDebitCardAvailable(boolean isDebitCardAvailable) {
		this.isDebitCardAvailable = isDebitCardAvailable;
	}

	public String getcINNumber() {
		return cINNumber;
	}

	public void setcINNumber(String cINNumber) {
		this.cINNumber = cINNumber;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Date getAccountOpenedData() {
		return accountOpenedData;
	}

	public void setAccountOpenedData(Date accountOpenedData) {
		this.accountOpenedData = accountOpenedData;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	

	public List<PaymentCardDetails> getCardsList() {
		return cardsList;
	}

	public void setCardsList(PaymentCardDetails card) {
		this.cardsList.add(card);
	}

}
