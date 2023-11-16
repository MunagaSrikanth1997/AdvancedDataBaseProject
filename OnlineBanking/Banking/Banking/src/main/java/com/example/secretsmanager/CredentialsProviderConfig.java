package com.example.secretsmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;

@Configuration
@Order(1)
public class CredentialsProviderConfig {
	// Configure AWS credentials using the AWS credentials provider chain
	// AwsCredentialsProvider awsCredentialsProvider =
	// DefaultCredentialsProvider.builder().build();

	

	@Bean
	public AwsCredentialsProvider getAwsCredentials() {
		// Alternatively, you can specify credentials directly
		 AwsCredentials awsCredentials = AwsBasicCredentials.create(accessKey,
		 secretKey);
		 AwsCredentialsProvider awsCredentialsProvider =
		 StaticCredentialsProvider.create(awsCredentials);
		//AwsCredentialsProvider awsCredentialsProvider = DefaultCredentialsProvider.builder().build();
		return awsCredentialsProvider;
	}

	// Create an S3 client with the configured credentials
	// For example, using the AWS SDK for S3
	// AmazonS3 s3Client =
	// AmazonS3Client.builder().credentialsProvider(awsCredentialsProvider).build();

}
