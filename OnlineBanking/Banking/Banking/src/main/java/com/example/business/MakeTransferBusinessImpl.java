package com.example.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.datarepo.MakeInternalAccountTransferService;
import com.example.objects.MakeTransfer;

@Component
public class MakeTransferBusinessImpl implements MakeTransferBusiness {

	@Autowired
	MakeInternalAccountTransferService makeInternalTransferService;
	@Override
	public String makeInternalTransfer(MakeTransfer makeTransfer) {
		
		String response=makeInternalTransferService.makeInternalTransfer(makeTransfer.getFromAccount(), makeTransfer.getToAccount(), makeTransfer.getAmount());
		
		
		
		return response;
	}

}
