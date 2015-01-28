package ro.patret.holidays.model;

import javax.mail.MessagingException;

import ro.patret.holidays.service.EmailService;

public class Email {
 	private String to;
	private String from;
	private String subject;
	private String body;
	private EmailService emailService;

	public Email(String to, String from, String subject, String body, EmailService emailService) {
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.body = body;
		this.emailService = emailService;
	}

	public void send() throws MessagingException {
	 	emailService.sendEmail(this);
	}

	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}
}
