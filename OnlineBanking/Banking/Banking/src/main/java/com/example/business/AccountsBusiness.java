package com.example.business;

import java.util.List;

import com.example.objects.Account;
import com.example.objects.OpenAccount;

public interface AccountsBusiness {

	public String openAccount(OpenAccount account);
	public List<Account> getAccountsList(String userId);
	
	
}
