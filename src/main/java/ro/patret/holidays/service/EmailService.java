package ro.patret.holidays.service;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ro.patret.holidays.configuration.EmailServerConfig;
import ro.patret.holidays.model.Email;

public class EmailService {

	private static final String HOST_PROPERTY = "mail.smtp.host";
	private static final String PORT_PROPERTY = "mail.smtp.port";
	private static final String AUTH_PROPERTY = "mail.smtp.auth";
	private static final String TLS_PROPERTY = "mail.smtp.starttls.enable";

	private Session session;
	private boolean isAuthRequired;
	private String username;
	private String password;


	public EmailService() {
		String mailServer = EmailServerConfig.getHost();
		String mailServerPort = EmailServerConfig.getPort();
		isAuthRequired = EmailServerConfig.isAuthenticationRequired();
		boolean isTlsEnabled = EmailServerConfig.isTlsEnabled();
		Properties props = new Properties();

		props.setProperty(HOST_PROPERTY, mailServer);
		props.setProperty(PORT_PROPERTY, mailServerPort);

		if (isTlsEnabled) {
			props.setProperty(TLS_PROPERTY, Boolean.TRUE.toString());
		}

		if (isAuthRequired) {
			props.setProperty(AUTH_PROPERTY, Boolean.TRUE.toString());
			username = EmailServerConfig.getUsername();
			password = EmailServerConfig.getPassword();
		}

		session = Session.getInstance(props);
	}

	public void sendEmail(Email email) throws MessagingException {
		Transport transport = null;
		try {

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(email.getFrom()));
			InternetAddress[] recipients = {new InternetAddress(email.getTo())};
			msg.setRecipients(Message.RecipientType.TO, recipients);
			msg.setSubject(email.getSubject());
			msg.setText(email.getBody());
			if (isAuthRequired) {
				transport = session.getTransport("smtp");
				transport.connect(username, password);
				transport.sendMessage(msg, msg.getAllRecipients());
			} else {
				Transport.send(msg);
			}
		} finally {
			if (transport != null) {
				try {
					transport.close();
				} catch (MessagingException e) {
					//log exception? nothing else to do here
				}
			}
		}
	}
}
