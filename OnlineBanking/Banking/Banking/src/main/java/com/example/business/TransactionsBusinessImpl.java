package com.example.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.datarepo.TransactionsService;
import com.example.objects.TransactionsData;

@Component
public class TransactionsBusinessImpl implements TransactionsBusiness {
	@Autowired
	TransactionsService transactionsService;

	@Override
	public List<TransactionsData> getTransactions(String userGuid) {

		return transactionsService.getTransactionsByUser(userGuid);
		// TODO Auto-generated method stub

	}

	@Override
	public List<TransactionsData> getAllTransactions() {
		// TODO Auto-generated method stub
		return transactionsService.getAllTransactions();
	}
	
	

}
