package com.example.datarepo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.objects.Account;
import com.example.objects.MakeTransfer;
import com.example.objects.PaymentCardDetails;
import com.example.objects.TransactionsData;
import com.example.objects.User;
import com.example.util.OnlineBankingUtility;

import io.micrometer.common.util.StringUtils;

@Service
public class CardServieImpl implements CardService {

	private final MongoTemplate mongoTemplate;
	String collectionName = "CUSTOMER_ACCOUNT_DATA";
	String TransactionCollection="TRANSACTION_DATA";
	String userData = "CUSTOMER_DATA";

	@Autowired
	public CardServieImpl(MongoTemplate mongoTemplate) {

		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public String cardPayments(MakeTransfer cardTransfer) {
		Query fromAccounts = new Query(Criteria.where("cardsList.cardNumber").is(cardTransfer.getCardNumber()));
		Query toAccounts = new Query(Criteria.where("accountNumber").is(cardTransfer.getToAccount()));
		// Query toAccounts = new
		// Query(Criteria.where("accountNumber").is(toAccountNumber));
		String statusMessage = "";
		Query customerInfo = null;
		Query FromcustomerInfo = null;
Account toAccount=null;
		TransactionsData trans=new TransactionsData();
		List<Account> fromAccountInfo = mongoTemplate.find(fromAccounts, Account.class, collectionName);
		List<Account> toAccountInfo = mongoTemplate.find(toAccounts, Account.class, collectionName);
		if (null != fromAccountInfo && !fromAccountInfo.isEmpty() && fromAccountInfo.size() == 1) {
			for (PaymentCardDetails cardDetails : fromAccountInfo.get(0).getCardsList()) {

				if (cardDetails.getCardNumber().equals(cardTransfer.getCardNumber())) {
					if (OnlineBankingUtility.cardValidator(cardDetails, cardTransfer.getCardNumber(),
							cardTransfer.getcVV(), cardTransfer.getValidThroughDate())) {
						if (cardDetails.getIsCreditCard()) {

						} else {
							
							if (fromAccountInfo.get(0).getAvailableBlance().compareTo(cardTransfer.getAmount()) >= 0) {
								FromcustomerInfo = new Query(Criteria.where("userGuid").is(fromAccountInfo.get(0).getUserGuid()));
								List<User> profileInfo1 = mongoTemplate.find(FromcustomerInfo, User.class, userData);
								fromAccountInfo.get(0).setAvailableBlance(
										fromAccountInfo.get(0).getAvailableBlance().subtract(cardTransfer.getAmount()));
								Account fromAccountResponse=mongoTemplate.save( fromAccountInfo.get(0), collectionName);
								trans.setUserId(profileInfo1.get(0).getUserId());
								trans.setTransactionId(UUID.randomUUID().toString());
								trans.setUserGuid(fromAccountInfo.get(0).getUserGuid());
								trans.setPaymentSource(cardTransfer.getCardNumber());
								trans.setPaymentDestination(cardTransfer.getToAccount());
								trans.setAmount(cardTransfer.getAmount());
								trans.setPaymentType(null!=cardTransfer.getPaymentType()?cardTransfer.getPaymentType():"Account pay Internal Transfer");
								trans.setTransactionDate(new Date());
								if(null!=fromAccountResponse) {
									statusMessage="Payment was successFull";
									trans.setPaymentStatus("SUCCESS");
								}else {
									trans.setPaymentStatus("Failed");
								}
								mongoTemplate.insert(trans, TransactionCollection);
								if(null!=toAccountInfo && toAccountInfo.size()==1) {
									toAccount=toAccountInfo.get(0);
									toAccount.setAvailableBlance(toAccountInfo.get(0).getAvailableBlance().add(cardTransfer.getAmount()));
									Account toAccountresponse=mongoTemplate.save( toAccount, collectionName);
									if(null!=toAccountresponse && null!=fromAccountResponse) {
										statusMessage="Payment was successFull";
										trans.setPaymentStatus("SUCCESS");
									}
									if(!fromAccountInfo.get(0).getUserGuid().equalsIgnoreCase(toAccountInfo.get(0).getUserGuid())) {
										customerInfo = new Query(Criteria.where("userGuid").is(toAccountInfo.get(0).getUserGuid()));
										List<User> profileInfo = mongoTemplate.find(customerInfo, User.class, userData);
										trans.setUserId(profileInfo.get(0).getUserId());
										trans.setUserGuid(toAccountInfo.get(0).getUserGuid());
										mongoTemplate.insert(trans, TransactionCollection);
									}
								}
								
								
								
								
								
								
								
							} else {
								statusMessage = "Insufficient Funds";
							}
						}
					}
				}

			}
			
		} else {
			System.out.println(":Invalid card Number:");
		}
		System.out.println(fromAccountInfo);
		return "success";
	}

}
