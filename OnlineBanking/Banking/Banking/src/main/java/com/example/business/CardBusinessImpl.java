package com.example.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.datarepo.CardService;
import com.example.objects.MakeTransfer;

@Configuration
public class CardBusinessImpl implements CardBusiness {

	@Autowired
	CardService cardServiceImpl;

	@Override
	public String cardPayment(MakeTransfer cardtransferReq) {

		String response = cardServiceImpl.cardPayments(cardtransferReq);
		return response;
	}

}
