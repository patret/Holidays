package ro.patret.holidays.model;

import java.text.MessageFormat;
import java.util.Date;

import javax.mail.MessagingException;

import ro.patret.holidays.configuration.HolidayRequestConfig;
import ro.patret.holidays.service.EmailService;

public class HolidayRequest {

	private String employeeName;
	private String employeeEmail;
	private String managerEmail;

	// holiday period
	private Date from;
	private Date to;

	private EmailService emailService;

	public HolidayRequest(String employeeName, String employeeEmail, String managerEmail, Date from, Date to) {
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.managerEmail = managerEmail;
		this.from = from;
		this.to = to;
		emailService = new EmailService();
	}

	public void submit() throws MessagingException {
		String subject = HolidayRequestConfig.getEmailSubject();
		String messageTemplate = HolidayRequestConfig.getSubmitTemplate();
		String body = MessageFormat.format(messageTemplate, from, to, employeeName);
		Email email = new Email(managerEmail, employeeEmail, subject, body, emailService);
		email.send();
	}

	public void approve() throws MessagingException {
		String subject = HolidayRequestConfig.getEmailSubject();
		String messageTemplate = HolidayRequestConfig.getApproveTemplate();
		String body = MessageFormat.format(messageTemplate, from, to, employeeName, employeeEmail);
		String hrEmail = HolidayRequestConfig.getHrEmail();
		Email email = new Email(hrEmail, managerEmail, subject, body, emailService);
		email.send();
	}

	public void reject() throws MessagingException {
		String subject = HolidayRequestConfig.getEmailSubject();
		String messageTemplate = HolidayRequestConfig.getSubmitTemplate();
		String body = MessageFormat.format(messageTemplate, from, to, employeeName);
		Email email = new Email(employeeEmail, managerEmail, subject, body, emailService);
		email.send();
	}
}