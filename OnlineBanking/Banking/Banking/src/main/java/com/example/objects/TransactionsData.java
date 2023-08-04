package com.example.objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionsData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4956382056990288773L;
	private String userGuid;
	private String paymentSource;
	private String paymentDestination;
	private BigDecimal amount;
	private String paymentType;
	private String comments;
	private Date transactionDate;
	private String paymentStatus;
	private String reason;
	private String transactionId;
	private String userId;

	public String getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}

	public String getPaymentSource() {
		return paymentSource;
	}

	public TransactionsData setPaymentSource(String paymentSource) {
		this.paymentSource = paymentSource;
		return this;
	}

	public String getPaymentDestination() {
		return paymentDestination;
	}

	public TransactionsData setPaymentDestination(String paymentDestination) {
		this.paymentDestination = paymentDestination;
		return this;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public TransactionsData setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public TransactionsData setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public String getComments() {
		return comments;
	}

	public TransactionsData setComments(String comments) {
		this.comments = comments;
		return this;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public TransactionsData setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
		return this;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public TransactionsData setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
		return this;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
