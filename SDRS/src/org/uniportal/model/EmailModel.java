package org.uniportal.model;

import java.io.File;

public class EmailModel {

	String receiverName;
	String subject;
	String content;
	File attachment;
	String fileName;
	String[] toEmail;
	String fromEmail;

	public EmailModel() {
	}

	public EmailModel(String receiverName, String subject, String content,
			File attachment, String[] toEmail, String fromEmail, String fileName) {
		super();
		this.receiverName = receiverName;
		this.subject = subject;
		this.content = content;
		this.attachment = attachment;
		this.toEmail = toEmail;
		this.fromEmail = fromEmail;
		this.fileName = fileName;
	}

	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public File getAttachment() {
		return attachment;
	}
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}
	public String[] getToEmail() {
		return toEmail;
	}
	public void setToEmail(String[] toEmail) {
		this.toEmail = toEmail;
	}
	public void setOneToEmail(String toEmail, int index) {
		this.toEmail[index] = toEmail;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
