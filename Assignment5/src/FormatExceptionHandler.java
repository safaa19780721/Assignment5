import java.io.*;

public class FormatExceptionHandler implements IFormatExceptionHandler {

	@Override
	public void handleFileNotFoundException(FileNotFoundException e) {
		String fileName = e.getMessage(); //may need to add a message to this one to get filename
		System.out.println(fileName + "(The system cannot find the file specified)");
	}

	@Override
	public void handlePhoneNumberNotFoundException(PhoneNumberFormatException e) {
		String phoneNum = e.getMessage();
		char[] phone = phoneNum.toCharArray();
		char[] corrected = new char[14];
		int i =0;
		corrected[0] = '(';
		int j = 1;
		while(j < 4)
		{
			if(Character.isDigit(phone[i]))
			{
					corrected[j] = phone[i];
					j++;
			}
			i++;
		}
		corrected[j] = ')';
		j++;
		corrected[j] = '-';
		j++;
		while(j < 9)
		{
			if(Character.isDigit(phone[i]))
			{
					corrected[j] = phone[i];
					j++;
			}
			i++;
		}
		corrected[j] = '-';
		j++;
		while(j < 14 &&  i < phone.length)
		{
			if(Character.isDigit(phone[i]))
			{
					corrected[j] = phone[i];
					j++;
			}
			i++;
		}
		System.out.println(corrected);
	}

	@Override
	public void handleEmailFormatNotFoundException(EmailAddressFormatException e) {
		String givenEmail = e.getMessage();
		char[] email = givenEmail.toCharArray();
		for(int i = 0; i < email.length; i++)
		{
			if(email[i] != '@' | email[i] != '.')
			{
				if(Character.isUpperCase(email[i]))
				{
					email[i] = Character.toLowerCase(email[i]);
				}
			}
		}
		System.out.println(email);
	}

	@Override
	public void handleNameFormatNotFoundException(NameFormatException e) {
		String givenName = e.getMessage();
		char[] name = givenName.toCharArray();
		if(Character.isLowerCase(name[0]))
		{
			name[0] = Character.toUpperCase(name[0]);
		}
		int i = 1;
		while(!(Character.isSpaceChar(name[i])))
		{
			name[i] = Character.toLowerCase(name[i]);
			i++;
		}
		i++; //leave the space in the name
		if(Character.isLowerCase(name[i]))
		{
			name[i] = Character.toUpperCase(name[i]);
		}
		i++;
		for(int j = i; j < name.length; j++)
		{
			name[j] = Character.toLowerCase(name[j]);
		}
		System.out.println(name);
	}
	
}