package com.example.datarepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.objects.Account;

@Repository
public class AccountServiceImpl implements AccountsService {

	private final MongoTemplate mongoTemplate;
	String collectionName = "CUSTOMER_ACCOUNT_DATA";

	@Autowired
	public AccountServiceImpl(MongoTemplate mongoTemplate) {

		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Account openAccount(Account account) {
		// TODO Auto-generated method stub
		Query checkAccountNumber = new Query(Criteria.where("accountNumber").is(account.getAccountNumber()));
		// if(!mongoTemplate.exists(checkAccountNumber, collectionName)) {
		Account response = mongoTemplate.insert(account, collectionName);
		// }

		return response;
	}

	@Override
	public List<Account> getAccountList() {
		// TODO Auto-generated method stub
		Query getAccountsList = new Query(Criteria.where("userGuid").is("64ad75f7a66f7b1fddb64740"));
		List<Account> accountsList = mongoTemplate.find(getAccountsList, Account.class, collectionName);
		return accountsList;
	}

}
