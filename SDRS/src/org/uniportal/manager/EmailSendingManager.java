package org.uniportal.manager;

import java.io.File;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.uniportal.model.EmailModel;
import org.uniportal.utils.GenericEmailSender;

@Service
public class EmailSendingManager {

	private EmailModel email = new EmailModel();

	@Autowired
	private SimpleMailMessage emailTemplate;

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	public void sendMail(String receiverName, String subject, String content,
			File attachment, String fileName, String[] toEmail, String fromEmail)
			throws MessagingException {

		this.prepareEmail(receiverName, subject, content, attachment, fileName,
				toEmail, fromEmail);
		GenericEmailSender.sendMail(email, javaMailSender);
	}

	/**
	 * Construct mail Model
	 * 
	 * @param receiverName
	 * @param subject
	 * @param content
	 * @param attachment
	 * @param toEmail
	 * @param fromEmail
	 */

	private void prepareEmail(String receiverName, String subject,
			String content, File attachment, String fileName, String[] toEmail,
			String fromEmail) {
		if (receiverName != null) {
			this.email.setReceiverName(receiverName);
		} else {
			this.email.setReceiverName(receiverName);
		}
		if (subject != null) {
			this.email.setSubject(subject);
		} else {
			this.email.setSubject(emailTemplate.getSubject());
		}
		if (content != null) {
			this.email.setContent(content);
		} else {
			this.email.setContent(emailTemplate.getText());
		}
		if (toEmail != null) {
			this.email.setToEmail(toEmail);
		} else {
			this.email.setToEmail(emailTemplate.getTo());
		}

		if (fromEmail != null) {
			this.email.setFromEmail(fromEmail);
		} else {
			this.email.setFromEmail(emailTemplate.getFrom());
		}
		if (attachment != null && fileName != null) {
			this.email.setFileName(fileName);
		}
		if (attachment != null) {
			this.email.setAttachment(attachment);
		}
	}

	public EmailModel getEmail() {
		return email;
	}

	public void setEmail(EmailModel email) {
		this.email = email;
	}

	public void setEmailTemplate(SimpleMailMessage emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

}
