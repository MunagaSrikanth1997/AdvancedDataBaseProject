package com.example.datarepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.objects.TransactionsData;

@Service
public class TransactionsServiceImpl implements TransactionsService {
	private final MongoTemplate mongoTemplate;

	String transactionCollection = "TRANSACTION_DATA";

	@Autowired
	public TransactionsServiceImpl(MongoTemplate mongoTemplate) {

		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<TransactionsData> getTransactionsByUser(String userGuid) {
		// TODO Auto-generated method stub

		Query transactionsByUserGuid = new Query(Criteria.where("userGuid").is(userGuid));
		List<TransactionsData> transactionList = mongoTemplate.find(transactionsByUserGuid, TransactionsData.class,
				transactionCollection);
		return transactionList;
	}

	@Override
	public List<TransactionsData> getAllTransactions() {
		List<TransactionsData> transactionList = mongoTemplate.findAll(TransactionsData.class,
				transactionCollection);
		return transactionList;
	}

}
