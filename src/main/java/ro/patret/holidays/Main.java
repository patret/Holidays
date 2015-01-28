package ro.patret.holidays;

import java.util.Date;

import javax.mail.MessagingException;

import ro.patret.holidays.model.HolidayRequest;

public class Main {

	private static final String EMPLOYEE_NAME = "employee-name";
	private static final String EMPLOYEE_EMAIL = "dragos.oana.mail.server@gmail.com";
	private static final String MANAGER_EMAIL = "dragos.oana.mail.server@gmail.com";
	private static final Date DATE = new Date();

	public static void main(String[] args) throws MessagingException {
		HolidayRequest request = new HolidayRequest(EMPLOYEE_NAME, EMPLOYEE_EMAIL, MANAGER_EMAIL, DATE, DATE);
		request.submit();
		request.approve();
		request.reject();
	}
}
