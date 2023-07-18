package com.example.datarepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.objects.Account;
import com.example.objects.MakeTransfer;
import com.example.objects.PaymentCardDetails;
import com.example.util.OnlineBankingUtility;

import io.micrometer.common.util.StringUtils;

@Service
public class CardServieImpl implements CardService {

	private final MongoTemplate mongoTemplate;
	String collectionName = "CUSTOMER_ACCOUNT_DATA";

	@Autowired
	public CardServieImpl(MongoTemplate mongoTemplate) {

		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public String cardPayments(MakeTransfer cardTransfer) {
		Query fromAccounts = new Query(Criteria.where("cardsList.cardNumber").is(cardTransfer.getCardNumber()));
		// Query toAccounts = new
		// Query(Criteria.where("accountNumber").is(toAccountNumber));
		String statusMessage = "";
		List<Account> fromAccountInfo = mongoTemplate.find(fromAccounts, Account.class, collectionName);
		if (null != fromAccountInfo && !fromAccountInfo.isEmpty() && fromAccountInfo.size() == 1) {
			for (PaymentCardDetails cardDetails : fromAccountInfo.get(0).getCardsList()) {

				if (cardDetails.getCardNumber().equals(cardTransfer.getCardNumber())) {
					if (OnlineBankingUtility.cardValidator(cardDetails, cardTransfer.getCardNumber(),
							cardTransfer.getCVV(), cardTransfer.getValidThroughDate())) {
						if (cardDetails.getIsCreditCard()) {

						} else {
							if (fromAccountInfo.get(0).getAvailableBlance().compareTo(cardTransfer.getAmount()) >= 0) {
								// toAccount.setAvailableBlance(toAccount.getAvailableBlance().add(amount));
								fromAccountInfo.get(0).setAvailableBlance(
										fromAccountInfo.get(0).getAvailableBlance().subtract(cardTransfer.getAmount()));
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
