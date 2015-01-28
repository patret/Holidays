package ro.patret.holidays.configuration;

public class HolidayRequestConfig {

	private static final String SUBMIT_TEMPLATE = "Dear Sir/Madam,\n\nI would like to go on holiday from {0} to"
		+ " {1}\n\nBest Regards,\n{2}";

	private static final String APPROVE_TEMPLATE = "Dear Sir/Madam,\n\nI approve the holiday request for the "
		+ "employee {0}({1}) from {2} to {3}\n\nBest Regards.";

	private static final String REJECT_TEMPLATE = "Dear {0},\n\nI am sorry to inform you that your holiday "
		+ "request from {1} to {2} has been rejected.\n\nBest Regards.";

	private static final String HR_EMAIL = "dragos.oana.mail.server@gmail.com";

	private static final String EMAIL_SUBJECT = "subject";

	public static String getSubmitTemplate() {
		return SUBMIT_TEMPLATE;
	}

	public static String getApproveTemplate() {
		return APPROVE_TEMPLATE;
	}

	public static String getRejectTemplate() {
		return REJECT_TEMPLATE;
	}

	public static String getHrEmail() {
		return HR_EMAIL;
	}

	public static String getEmailSubject() {
		return EMAIL_SUBJECT;
	}
}
