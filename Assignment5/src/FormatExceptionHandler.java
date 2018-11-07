import java.io.*;

public class FormatExceptionHandler implements IFormatExceptionHandler {

	@Override
	public void handleFileNotFoundException(FileNotFoundException e) {
		String fileName = e.getMessage(); //may need to add a message to this one to get filename
		System.out.println(fileName + "The system cannot find the file specified");
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
		corrected[4] = ')';
		corrected[5] = '-';
		while(j < 9)
		{
			if(Character.isDigit(phone[i]))
			{
					corrected[j] = phone[i];
					j++;
			}
			i++;
		}
		corrected[9] = '-';
		while(j < 14)
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleNameFormatNotFoundException(NameFormatException e) {
		// TODO Auto-generated method stub
		
	}
	
}