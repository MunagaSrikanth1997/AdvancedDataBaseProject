package com.example.datarepo;

import java.util.List;

import com.example.objects.TransactionsData;

public interface TransactionsService {

	
	
	public List<TransactionsData> getTransactionsByUser(String userGuid);
	
	public List<TransactionsData> getAllTransactions();
}
