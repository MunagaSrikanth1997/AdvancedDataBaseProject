package com.example.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.datarepo.AccountsService;
import com.example.datarepo.UserService;
import com.example.objects.Account;
import com.example.objects.OpenAccount;
import com.example.objects.PaymentCardDetails;
import com.example.objects.User;
import com.example.util.OnlineBankingUtility;

@Component
public class AccountsBusinessImpl implements AccountsBusiness {

	@Autowired
	AccountsService accountService;
	@Autowired
	UserService userService;

	@Override
	public String openAccount(OpenAccount openNewAccount) {
		String response=null;
		System.out.println("AccountsBusinessImpl: Entering open account method ");
		try {
			User user=userService.getCustomerInformation(openNewAccount.getUserId());
			if(null==user) {
				return "user Does Not Exists";
			}
	Account account=new Account();
	account.setAccountName(openNewAccount.getAccountName());
			account.setAccountNumber(OnlineBankingUtility.generateRandomAccountNumber());
			account.setAccountStatus("OPEN");
			account.setcINNumber(OnlineBankingUtility.generateCintNumber());
			account.setAccountOpenedData(new Date());
			account.setUserGuid(user.getUserGuid());
			if(openNewAccount.isDebitCardRequired()) {
				account.setDebitCardAvailable(openNewAccount.isDebitCardRequired());
				PaymentCardDetails cardDetails = new PaymentCardDetails();
				cardDetails.setAccountNumber(account.getAccountNumber());
				cardDetails.setCardIssuedDate(new Date());
				cardDetails.setCardType("VISA");// need add some logic to change card types
				cardDetails.setUserGuid(user.getUserGuid());
				cardDetails.setCVV(OnlineBankingUtility.generateCVV());
				cardDetails.setCardValidThroughDate(OnlineBankingUtility.cardValidThrough());
				cardDetails.setIsCreditCard(false);
				cardDetails.setCardNumber(OnlineBankingUtility.generateFifteenDigitNumber());
				account.setCardsList(cardDetails);
			}
			
			account.setAvailableBlance(openNewAccount.getDepositAmount());
			account.setRoutingNumber(OnlineBankingUtility.generateRoutingNumber());
			
			Account accountServiceReponse = accountService.openAccount(account);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in AccountsBusinessImpl openAccount method");
			System.out.println(e.getStackTrace());
		}
		
		System.out.println("AccountsBusinessImpl: Exiting open account method ");
		return "Account Opened Successfully";
	}

	@Override
	public List<Account> getAccountsList(String userId) {
		// TODO Auto-generated method stub
		List<Account>accountsList=accountService.getAccountList(userId);
		return accountsList;
	}

}
