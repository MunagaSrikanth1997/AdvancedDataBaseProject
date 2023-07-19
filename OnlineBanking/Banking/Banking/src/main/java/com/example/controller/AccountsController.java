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
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/onlineBanking/accounts")
public class AccountsController {

	@Autowired
	AccountsBusiness accountBusiness;

	@PostMapping("/openAccount")
	public ResponseEntity<Account> openAccount(@RequestBody Account account, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession(false);
		if(null!=session && null!=session.getAttribute("USER_ID")) {
			account.setUserGuid(session.getAttribute("USER_ID").toString());// extract it from session
		}else {
			//throw user session timeout error
		}
		
		Account accountResponse = accountBusiness.openAccount(account);
		return ResponseEntity.status(200).body(accountResponse);

	}

	@GetMapping("/getAccountsList")
	public ResponseEntity<List<Account>> getAccountsList(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session=request.getSession(false);
		String userId=null;
		if(null!=session && null!=session.getAttribute("USER_ID")) {
			userId=session.getAttribute("USER_ID").toString();// extract it from session
		}else {
			//throw user session timeout error
		}
		List<Account> accountList = accountBusiness.getAccountsList(userId);

		return ResponseEntity.status(200).body(accountList);

	}

}
