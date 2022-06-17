package com.app.service;

import javax.mail.MessagingException;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

import com.app.entities.CandidateEntity;

public interface MailSenderServiceInterface {

	public static final JavaMailSender javaMailSender = null;
	
	
	
	public void sendEmail(CandidateEntity candidateEntity) throws MailException;
	
	
	public void sendEmailWithAttachment(CandidateEntity candidateEntity) throws MailException, MessagingException;
	
}
