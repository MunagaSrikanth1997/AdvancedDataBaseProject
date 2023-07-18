package com.example.datarepo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.objects.Account;
@Service
public class MakeInternalTransferServiceImpl implements MakeInternalAccountTransferService {

	private final MongoTemplate mongoTemplate;
	String collectionName = "CUSTOMER_ACCOUNT_DATA";

	@Autowired
	public MakeInternalTransferServiceImpl(MongoTemplate mongoTemplate) {

		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public String makeInternalTransfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
		// TODO Auto-generated method stub
		Query fromAccounts = new Query(Criteria.where("accountNumber").is(fromAccountNumber));
		Query toAccounts = new Query(Criteria.where("accountNumber").is(toAccountNumber));
		String statusMessage="";
		List<Account> fromAccountInfo = mongoTemplate.find(fromAccounts, Account.class, collectionName);
		List<Account> toAccountInfo = mongoTemplate.find(toAccounts, Account.class, collectionName);
		Account toAccount = null;
		Account fromAccount = null;
		if (null != toAccountInfo && toAccountInfo.size() == 1) {
			toAccount = toAccountInfo.get(0);
		}
		if (null != fromAccountInfo && fromAccountInfo.size() == 1) {
			fromAccount = fromAccountInfo.get(0);

		}

		if (null == toAccount || null == fromAccount) {
			// from or to account is not available
			statusMessage="from or to account is not valid";
		}

		if (fromAccount.getAvailableBlance().compareTo(amount) >= 0) {
			toAccount.setAvailableBlance(toAccount.getAvailableBlance().add(amount));
			fromAccount.setAvailableBlance(fromAccount.getAvailableBlance().subtract(amount));
		}else {
			statusMessage="Insufficient Funds";
		}
		Account toAccountresponse=mongoTemplate.save( toAccount, collectionName);
		Account fromAccountResponse=mongoTemplate.save( fromAccount, collectionName);
		if(null!=toAccountresponse && null!=fromAccountResponse) {
			statusMessage="Payment was successFull";
		}

		return statusMessage;
	}

}
