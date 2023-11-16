package com.example.secretsmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;


@Configuration
public class SecretsManager {
    @Autowired
    private CredentialsProviderConfig credentialsProviderConfig;
    String region = "us-east-1"; 
   //DevDocumentDB
    public String getSecretsManager(String secretName) {
    	String secretValue =null;
    	 SecretsManagerClient secretsManagerClient = SecretsManagerClient.builder()
    	            .region(Region.of(region))
    	            .credentialsProvider(credentialsProviderConfig.getAwsCredentials())
    	            .build();
    	    GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
    	            .secretId(secretName)
    	            .build();
    	    try {
    	        // Get the secret value
    	        GetSecretValueResponse getSecretValueResponse = secretsManagerClient.getSecretValue(getSecretValueRequest);
    	       
    	        // Access the secret value
    	         secretValue = getSecretValueResponse.secretString();
    	        
    	    } catch (Exception e) {
    	        System.err.println("Error fetching secret: " + e.getMessage());
    	    } finally {
    	        // Close the Secrets Manager client
    	        secretsManagerClient.close();
    	    }
    	    return secretValue;
    }
    // Create a Secrets Manager client
   
}
