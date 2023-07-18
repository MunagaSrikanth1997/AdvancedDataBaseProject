package com.example.datarepo;

import org.springframework.stereotype.Service;

import com.example.objects.MakeTransfer;

@Service
public interface CardService {

	public String cardPayments(MakeTransfer cardTransfer);
}
