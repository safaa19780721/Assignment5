import java.io.*;

public interface IFormatExceptionHandler {

	void handleFileNotFoundException(FileNotFoundException e);

	void handlePhoneNumberNotFoundException(PhoneNumberFormatException e);

	void handleEmailFormatNotFoundException(EmailAddressFormatException e);

	void handleNameFormatNotFoundException(NameFormatException e);

}