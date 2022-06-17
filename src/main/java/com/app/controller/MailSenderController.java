package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.CandidateEntity;
import com.app.service.MailSenderServiceInterface;

@RestController
public class MailSenderController {

	
	@Autowired
	private MailSenderServiceInterface mailSenderServiceInterface;
	
	@Autowired
	private CandidateEntity candidateEntity;
	
	
	@PostMapping("send-mail")
	public String send() {
		candidateEntity.setName("abc");
		
		candidateEntity.setEmail("abc.l786@gmail.com");
		try {
			mailSenderServiceInterface.sendEmail(candidateEntity);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
	
}
