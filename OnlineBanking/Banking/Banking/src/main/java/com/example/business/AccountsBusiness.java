package com.example.business;

import java.util.List;

import com.example.objects.Account;

public interface AccountsBusiness {

	public Account openAccount(Account account);
	public List<Account> getAccountsList(String userId);
	
	
}
