package com.example.datarepo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.emailnotification.EmailNotification;
import com.example.objects.User;
import com.example.secretsmanager.SecretsManager;

@Service
public class UserService {
	private final MongoTemplate mongoTemplate;
	String collectionName = "CUSTOMER_DATA";
	@Autowired
	public UserService(MongoTemplate mongoTemplate) {

		this.mongoTemplate = mongoTemplate;
	}
	@Autowired
	public EmailNotification emailNotification;
	@Autowired
	SecretsManager secretsManager;
//	@Autowired
//	public EmailNotoficationSMTP emailNotification;

	public String createCustomerCollectionAndInsert(User userData) {
		String response=null;
		System.out.println("Entering createCustomerCollectionAndInsert service Method");
		try {
			System.out.println("is collection exit:::::   " + !mongoTemplate.collectionExists(collectionName));
			if (!mongoTemplate.collectionExists(collectionName)) {
				CollectionOptions options = CollectionOptions.empty().size(1024);
				 
				mongoTemplate.createCollection(collectionName, options);
				response="collection already exists";
			} else {
				Query findById=new Query(Criteria.where("userId").is(userData.getUserId()).and("password").is(userData.getPassword()));
				if(!mongoTemplate.exists(findById, collectionName)) {
				ObjectId objectId = new ObjectId();
		        String guid = objectId.toString();
		        userData.setUserGuid(guid);
				mongoTemplate.insert(userData, collectionName);
				response="user Registered Successfully";
				emailNotification.sendEmailNotification(userData.getMail1(),"Registered","you are successfully Registered");
				
				}else {
					response="user already exists. please try with different userid";
				}
			}
		} catch (Exception e) {
			System.out.println("error while reguistering the user");
		}
		
		return response;

	}
	public List<User> validateCustomerCredentials(String userId,String password) {
		Query findById=new Query(Criteria.where("userId").is(userId).and("password").is(password));
		List<User> userList=mongoTemplate.find(findById,User.class,collectionName);
		System.out.println(userList);
		
		return userList;
	}
	public User getCustomerInformation(String userId) {
		Query findById=new Query(Criteria.where("userId").is(userId));
		List<User> userList=mongoTemplate.find(findById,User.class,collectionName);
		System.out.println(userList);
		
		return null!=userList?userList.get(0):null;
	}
	
}
