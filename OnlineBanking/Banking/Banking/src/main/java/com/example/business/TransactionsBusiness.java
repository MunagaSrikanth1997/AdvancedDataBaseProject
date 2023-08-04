package com.example.business;

import java.util.List;

import com.example.objects.TransactionsData;

public interface TransactionsBusiness {

	
	public List<TransactionsData> getTransactions(String userGuid);
	public List<TransactionsData> getAllTransactions();
}
