package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.business.TransactionsBusiness;
import com.example.objects.TransactionsData;
import com.example.objects.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/onlineBanking/transactions")
public class TransactionsController {
	@Autowired
	TransactionsBusiness transactionsBusiness;
	
	
	@GetMapping("/getCustomerTransactions")
	public ResponseEntity<List<TransactionsData>> getCustomerTransactions(@RequestParam("userGuid") String userGuid,HttpServletRequest request,HttpServletResponse response){
		
		List<TransactionsData> transactionData=transactionsBusiness.getTransactions(userGuid);
		
		return ResponseEntity.status(200).body(transactionData);
		
	}
}
