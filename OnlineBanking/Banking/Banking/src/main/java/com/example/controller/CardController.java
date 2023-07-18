package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.business.CardBusiness;
import com.example.objects.MakeTransfer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/onlineBanking/card")
@RestController
public class CardController {

	@Autowired
	CardBusiness cardBusinessImpl;

	@PostMapping("/cardTransfer")
	public ResponseEntity<String> cardTransfer(@RequestBody MakeTransfer makeTransfer,
			HttpServletRequest httpServletyRequest, HttpServletResponse httpResponse) {
		String response = cardBusinessImpl.cardPayment(makeTransfer);
		return null;

	}

}
