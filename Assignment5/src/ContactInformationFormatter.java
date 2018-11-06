import java.io.*;
import java.util.*;

public class ContactInformationFormatter implements IContactInformationFormatter {

	Scanner scanner;
	FormatExceptionHandler handle = new FormatExceptionHandler();
	String givenName;
	String givenNumber;
	String givenEmail;

	public void readContactInformation(String[] filePaths) {
		for (int i = 0; i < filePaths.length; i++) {
			formatContactInformation(filePaths[i]);
			givenName = "";
			givenNumber = "";
			givenEmail = "";
		}
	}

	public void formatContactInformation(String fileName) {
		try {
			scanner = new Scanner(new FileReader(new File(fileName)));
			try {
				formatName(scanner.nextLine());
			} catch (NameFormatException e) {
				handle.handleNameFormatNotFoundException(e);
			}

			try {
				formatPhoneNumber(scanner.nextLine());
			} catch (PhoneNumberFormatException e) {
				handle.handlePhoneNumberNotFoundException(e);
			}

			try {
				formatEmail(scanner.nextLine());
			} catch (EmailAddressFormatException e) {
				handle.handleEmailFormatNotFoundException(e);
			}
		} catch (FileNotFoundException e) {
			handle.handleFileNotFoundException(e);
		}

	}

	public void formatEmail(String email) throws EmailAddressFormatException {
		char[] e1 = email.toCharArray();
		for (int i = 0; i < e1.length; i++) {
			if (e1[i] == '.' || e1[i] == '@' || Character.isDigit(e1[i]) || Character.isLowerCase(e1[i])) {

			} else {
				throw new EmailAddressFormatException(email);
			}
		}
		givenEmail = email;
		if (givenEmail != "") {
			System.out.println(givenEmail);
		}
	}

	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		char[] n = phoneNumber.toCharArray();
		for (int i = 0; i < n.length; i++) {
			if (i == 0 && n[0] != '(') {
				throw new PhoneNumberFormatException(phoneNumber);
			} else if (i == 4 && n[4] != ')') {
				throw new PhoneNumberFormatException(phoneNumber);
			} else if (i == 5 && n[5] != '-') {
				throw new PhoneNumberFormatException(phoneNumber);
			} else if (i == 9 && n[9] != '-') {
				throw new PhoneNumberFormatException(phoneNumber);
			} else if (!Character.isDigit(n[i]) && i != 9 && i != 5 && i != 4 && i != 0) {
				throw new PhoneNumberFormatException(phoneNumber);
			}
		}
		givenNumber = phoneNumber;
		if (givenNumber != "") {
			System.out.println(givenNumber);
		}

	}

	public void formatName(String name) throws NameFormatException {
		String[] a = name.split(" ");
		char[] n = a[0].toCharArray();
		char[] na = a[1].toCharArray();

		for (int i = 0; i < n.length; i++) {
			if (Character.isUpperCase(n[i]) && i != 0) {
				throw new NameFormatException(name);
			}
		}
		for (int i = 0; i < na.length; i++) {
			if (Character.isUpperCase(na[i]) && i != 0) {
				throw new NameFormatException(name);
			}
		}
		givenName = name;
		if (givenName != "") {
			System.out.println(givenName);
		}
	}
}