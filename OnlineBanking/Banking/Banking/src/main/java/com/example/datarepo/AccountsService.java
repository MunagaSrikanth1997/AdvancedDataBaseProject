package com.example.datarepo;

import java.util.List;

import com.example.objects.Account;

public interface AccountsService {

	public Account openAccount(Account account);

	public List<Account> getAccountList(String userId);

}
