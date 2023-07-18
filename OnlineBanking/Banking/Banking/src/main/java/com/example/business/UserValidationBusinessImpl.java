package com.example.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.datarepo.UserService;
import com.example.mongodb.MongoDbConnectionConfig;
import com.example.objects.User;

@Component
public class UserValidationBusinessImpl implements UserValidationBusiness {

	@Autowired
	MongoDbConnectionConfig mongoDbConfig;
	@Autowired
	UserService userService;

	@Override
	public User userValidation(User user) {

		List<User> userList=userService.validateCustomerCredentials(user.getUserId(), user.getPassword());
		return userList!=null && userList.size()>0?userList.get(0):null;
	}

	@Override
	public String customerRegister(User user) {
		String businessRespo=userService.createCustomerCollectionAndInsert(user);
		return businessRespo;

	}

}
