package com.example.sqs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.example.secretsmanager.CredentialsProviderConfig;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;

@Configuration
public class SQSConfig {

	@Autowired
	CredentialsProviderConfig credentialsProviderConfig;

	
	public String getSQSQueueUrlByQueueName(String queueName) {
		GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder().queueName(queueName).build();

		GetQueueUrlResponse getQueueUrlResponse = getSqsClient().getQueueUrl(getQueueUrlRequest);
		String queueUrl = getQueueUrlResponse.queueUrl();
		return queueUrl;
	}

	public SqsClient getSqsClient() {
		SqsClient sqsClient = SqsClient.builder().region(Region.US_EAST_1) // Replace with your desired region
				.credentialsProvider(credentialsProviderConfig.getAwsCredentials()).build();
		return sqsClient;
	}

}
