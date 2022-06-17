package com.app.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.app.entities.CandidateEntity;
import com.app.service.MailSenderServiceInterface;

public class MailSenderServiceimpl implements MailSenderServiceInterface{

	@Override
	public void sendEmail(CandidateEntity candidateEntity) throws MailException {
SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(candidateEntity.getEmail());
		mail.setSubject("Testing Mail API");
		mail.setText("Hurray ! You have done that dude...");
		javaMailSender.send(mail);
	}

	@Override
	public void sendEmailWithAttachment(CandidateEntity candidateEntity) throws MailException, MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(candidateEntity.getEmail());
		helper.setSubject("Testing Mail API with Attachment");
		helper.setText("Please find the attached document below.");

		
		ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);

		javaMailSender.send(message);
		
	}

}
