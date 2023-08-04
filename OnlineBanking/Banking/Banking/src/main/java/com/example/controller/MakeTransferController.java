package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.business.MakeTransferBusiness;
import com.example.objects.MakeTransfer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/onlineBanking/transfer")
public class MakeTransferController {

	@Autowired
	MakeTransferBusiness makeTransferBusiness;

	@PostMapping("/makeInternalTransfer")
	public ResponseEntity<String> makePayment(@RequestBody MakeTransfer makeTransfer, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession(false);
		if(null!=session) {
			
			
			makeTransfer.setUserGuid(session.getAttribute("USER_ID").toString());
		}
		
		String transferResponse = makeTransferBusiness.makeInternalTransfer(makeTransfer);
		return ResponseEntity.status(200).body(transferResponse);

	}

}
