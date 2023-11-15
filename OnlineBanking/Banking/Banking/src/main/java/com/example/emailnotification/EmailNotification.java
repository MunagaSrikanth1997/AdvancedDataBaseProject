package com.example.emailnotification;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
@Configuration
public class EmailNotification {
	
	String accessKey = "YOUR_ACCESS_KEY";
    String secretKey = "YOUR_SECRET_KEY";

    // Replace this value with your AWS SES region
    Regions region = Regions.US_EAST_1;

    // Replace these values with your email addresses
    String senderAddress = "srikanthsiri.ms@gmail.com";
    
    
    public void sendEmailNotification(String recipientAddress, String mailSubject,String mailBody) {
    	AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .withRegion(region)
                .build();
    	// Create the content of the email
        Content subject = new Content().withData(mailSubject);
        Content body = new Content().withData(mailBody);
        Body emailBody = new Body().withText(body);
        Message message = new Message().withSubject(subject).withBody(emailBody);

        // Create the destination (recipient) of the email
        Destination destination = new Destination().withToAddresses(recipientAddress);

     // Create the request to send the email
        SendEmailRequest request = new SendEmailRequest()
                .withSource(senderAddress)
                .withDestination(destination)
                .withMessage(message);
        
        try {
            // Send the email
            SendEmailResult result = client.sendEmail(request);
            System.out.println("Email sent. Message ID: " + result.getMessageId());
        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    }

}
