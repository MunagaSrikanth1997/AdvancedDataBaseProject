package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.business.UserValidationBusiness;
import com.example.objects.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/onlineBanking")
public class LoginController {

	@Autowired
	UserValidationBusiness userValidationBusiness;

	@PostMapping("/login")
	public ResponseEntity<User> customerLogin(@RequestBody User user, HttpServletRequest request,
			HttpServletResponse response) {
		User userResponse = userValidationBusiness.userValidation(user);
		if (null != userResponse) {
			return ResponseEntity.status(200).body(userResponse);
		} else {
			return ResponseEntity.status(500).body(new User("Invalid Credentials", "500"));
		}

	}

	@PostMapping("/register")

	public ResponseEntity<String> customerRegister(@RequestBody User user) {
		String response = userValidationBusiness.customerRegister(user);
		return ResponseEntity.status(200).body(response);
	}

}
