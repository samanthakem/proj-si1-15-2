package util;

import java.util.regex.Pattern;

/**
 * Classe que possui os regex validos
 * @author Samantha Monteiro
 *
 */
public class RegexPattern {
	
	public static final Pattern VALID_EMAIL_ADDRESS = compilarRegex("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");
	
	public static final Pattern VALID_PHONE_NUMBER = compilarRegex("");
	
	public static final Pattern STRONG_PASSWORD = compilarRegex("");
	
	private static Pattern compilarRegex(String regex) {
		return Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	}
	
}
