package com.example.business;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.datarepo.AccountsService;
import com.example.objects.Account;
import com.example.objects.PaymentCardDetails;
import com.example.util.OnlineBankingUtility;

@Component
public class AccountsBusinessImpl implements AccountsBusiness {

	@Autowired
	AccountsService accountService;

	@Override
	public Account openAccount(Account account) {

		account.setAccountNumber(OnlineBankingUtility.generateRandomAccountNumber());
		account.setAccountStatus("OPEN");
		account.setcINNumber(OnlineBankingUtility.generateCintNumber());
		account.setAccountOpenedData(new Date());
		account.setDebitCardAvailable(true);
		account.setAvailableBlance(new BigDecimal("0"));
		account.setRoutingNumber(OnlineBankingUtility.generateRoutingNumber());
		PaymentCardDetails cardDetails = new PaymentCardDetails();
		cardDetails.setAccountNumber(account.getAccountNumber());
		cardDetails.setCardIssuedDate(new Date());
		cardDetails.setCardType("VISA");// need add some logic to change card types
		cardDetails.setUserGuid(account.getUserGuid());
		cardDetails.setCVV(OnlineBankingUtility.generateCVV());
		cardDetails.setCardValidThroughDate(OnlineBankingUtility.cardValidThrough());
		cardDetails.setIsCreditCard(false);
		cardDetails.setCardNumber(OnlineBankingUtility.generateFifteenDigitNumber());
		account.setCardsList(cardDetails);
		Account accountServiceReponse = accountService.openAccount(account);
		return accountServiceReponse;
	}

	@Override
	public List<Account> getAccountsList(String userId) {
		// TODO Auto-generated method stub
		List<Account>accountsList=accountService.getAccountList(userId);
		return accountsList;
	}

}
