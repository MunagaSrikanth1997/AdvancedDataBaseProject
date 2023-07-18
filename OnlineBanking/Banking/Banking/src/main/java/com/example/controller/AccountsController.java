package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.business.AccountsBusiness;
import com.example.objects.Account;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/onlineBanking/accounts")
public class AccountsController {

	@Autowired
	AccountsBusiness accountBusiness;

	@PostMapping("/openAccount")
	public ResponseEntity<Account> openAccount(@RequestBody Account account, HttpServletRequest request,
			HttpServletResponse response) {
		account.setUserGuid("64ad75f7a66f7b1fddb64740");// extract it from session
		Account accountResponse = accountBusiness.openAccount(account);
		return ResponseEntity.status(200).body(accountResponse);

	}

	@GetMapping("/getAccountsList")
	public ResponseEntity<List<Account>> getAccountsList(HttpServletRequest request, HttpServletResponse response) {
		List<Account> accountList = accountBusiness.getAccountsList();

		return ResponseEntity.status(200).body(accountList);

	}

}
