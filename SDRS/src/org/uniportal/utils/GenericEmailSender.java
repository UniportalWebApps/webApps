package org.uniportal.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.uniportal.model.EmailModel;

public class GenericEmailSender {

	public static void sendMail(EmailModel email, JavaMailSender javaMailSender)
			throws MessagingException {

		String fromEmail = email.getFromEmail();
		String[] toEmail = email.getToEmail();
		String emailSubject = email.getSubject();
		String emailBody = email.getContent();

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setFrom(fromEmail);
		helper.setTo(toEmail);
		helper.setSubject(emailSubject);
		helper.setText(emailBody);

		if (email.getAttachment() != null) {
			helper.addAttachment(email.getFileName(), email.getAttachment());
		}
		javaMailSender.send(mimeMessage);

	}

}
