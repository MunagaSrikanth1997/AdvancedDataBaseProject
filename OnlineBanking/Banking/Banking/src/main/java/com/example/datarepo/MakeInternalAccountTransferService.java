package com.example.datarepo;

import java.math.BigDecimal;

public interface MakeInternalAccountTransferService {

	
	public String makeInternalTransfer(String fromAccount,String toAccount,BigDecimal amount);
	
}
