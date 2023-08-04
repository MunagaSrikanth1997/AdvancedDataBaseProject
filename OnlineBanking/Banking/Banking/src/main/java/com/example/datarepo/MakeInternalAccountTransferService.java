package com.example.datarepo;

import java.math.BigDecimal;

public interface MakeInternalAccountTransferService {

	
	public String makeInternalTransfer(String userId,String fromAccount,String toAccount,BigDecimal amount);
	
}
