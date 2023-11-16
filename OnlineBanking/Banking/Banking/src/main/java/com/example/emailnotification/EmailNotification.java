package com.example.emailnotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.secretsmanager.CredentialsProviderConfig;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.Body;
import software.amazon.awssdk.services.ses.model.Content;
import software.amazon.awssdk.services.ses.model.Destination;
import software.amazon.awssdk.services.ses.model.Message;
import software.amazon.awssdk.services.ses.model.SendEmailRequest;
import software.amazon.awssdk.services.ses.model.SendEmailResponse;

@Configuration
public class EmailNotification {
	
	@Autowired
    private CredentialsProviderConfig credentialsProviderConfig;
	
    // Replace these values with your email addresses
    String senderAddress = "srikanthsiri.ms@gmail.com";
    String region = "us-east-1";
    
    public void sendEmailNotification(String recipientAddress, String mailSubject,String mailBody) {
    	SesClient sesClient = SesClient.builder()
                .region(Region.of(region)) // Replace with your desired region
                .credentialsProvider(credentialsProviderConfig.getAwsCredentials())
                .build();
    	Content subject = Content.builder().data(mailSubject).build();
        Content body = Content.builder().data(mailBody).build();
        Body emailBody = Body.builder().text(body).build();
        Message message = Message.builder().subject(subject).body(emailBody).build();

        // Specify the recipient
        Destination destination = Destination.builder().toAddresses(recipientAddress).build();

        // Create the request
        SendEmailRequest request = SendEmailRequest.builder()
                .source(senderAddress) // Replace with your sender email address
                .destination(destination)
                .message(message)
                .build();

        // Send the email
        SendEmailResponse response = sesClient.sendEmail(request);
        System.out.println("Email sent. Message ID: " + response.messageId());

        // Close the SES client
        sesClient.close();
    }

}
