package com.example.tmpproject.controller;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
public class Mail
{
    @Autowired
    private JavaMailSender javaMailSender=new JavaMailSenderImpl();
    public  void sendMail(String tomail,String subject,String text)
    {
        // Recipient's email ID needs to be mentioned.
        String to = tomail;

        // Create a default MimeMessage object.
        SimpleMailMessage msg = new SimpleMailMessage();

        // Set To: header field of the header.
        msg.setTo(to);

        // Set Subject: header field
        msg.setSubject(subject);

        // Now set the actual message
        msg.setText(text);

        System.out.println("sending...");
        // Send message
        javaMailSender.send(msg);
        System.out.println("Sent message successfully....");

    }

}
