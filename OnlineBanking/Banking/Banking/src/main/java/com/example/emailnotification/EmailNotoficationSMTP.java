package com.example.emailnotification;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Configuration;
@Configuration
public class EmailNotoficationSMTP {
	String smtpUsername = "your smtp user nae";
    String smtpPassword = "smtp pasword";
    String senderEmailAddress="srikanthsiri.ms@gmail.com";
    public void emailSendNotification(String recipientAddress, String mailSubject,String mailBody) {
    	Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "email-smtp.us-east-1.amazonaws.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmailAddress));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientAddress));
            message.setSubject(mailSubject);
            message.setText(mailBody);

            Transport transport = session.getTransport("smtp");
            transport.connect("email-smtp.us-east-1.amazonaws.com", smtpUsername, smtpPassword);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
