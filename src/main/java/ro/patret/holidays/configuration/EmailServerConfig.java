package ro.patret.holidays.configuration;

public class EmailServerConfig {

	private static final String HOST = "smtp.gmail.com";

	private static final String PORT = "587";

	private static final boolean AUTHENTICATION_REQUIRED = true;

	private static final boolean TLS_ENABLED = true;

	private static final String username = "dragos.oana.mail.server";

	private static final String password = "mailServer";

	public static String getHost() {
		return HOST;
	}

	public static String getPort() {
		return PORT;
	}

	public static boolean isAuthenticationRequired() {
		return AUTHENTICATION_REQUIRED;
	}

	public static boolean isTlsEnabled() {
		return TLS_ENABLED;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}
}
