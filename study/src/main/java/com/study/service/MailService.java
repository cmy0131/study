package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(String toEmail, String body, String subject) {
		
		SimpleMailMessage simpleMessage=new SimpleMailMessage();
		
		simpleMessage.setFrom("worldbest2030k@gmail.com");
		simpleMessage.setTo(toEmail);
		simpleMessage.setSubject(subject);
		simpleMessage.setText(body);
		
		javaMailSender.send(simpleMessage);
		
		System.out.println("Mail Sent Successfully...");
		
	}
	
	
}
