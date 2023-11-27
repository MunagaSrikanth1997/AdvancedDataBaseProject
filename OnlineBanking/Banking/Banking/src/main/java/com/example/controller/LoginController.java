package com.example.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.business.UserValidationBusiness;
import com.example.objects.User;
import com.example.errorobjects.Error;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@RestController
@RequestMapping("/onlineBanking")
public class LoginController {
public LoginController() {
	
}
	@Autowired
	UserValidationBusiness userValidationBusiness;

	@PostMapping("/login")
	public ResponseEntity<User> customerLogin(HttpServletRequest request, 
			HttpServletResponse response,@RequestBody User user) {
		User userResponse = userValidationBusiness.userValidation(user);
		if (null != userResponse) {
			HttpSession session=request.getSession(true);
			String sessionId = UUID.randomUUID().toString();
			session.setAttribute("SESSION_ID", sessionId);
			session.setAttribute("USER_ID", userResponse.getUserGuid());
			session.setAttribute("USER_INFO", userResponse);
			return ResponseEntity.status(200).body(userResponse);
		} else {
			return ResponseEntity.status(500).body(new User().setError(new Error("Invalid Credentials", "500")));
		}

	}

	@PostMapping("/register")

	public ResponseEntity<String> customerRegister(@RequestBody User user) {
		System.out.println("Entering Register Method");
		String response = userValidationBusiness.customerRegister(user);
		System.out.println("Exiting Register Method");
		return ResponseEntity.status(200).body(response);
	}

}
