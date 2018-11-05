import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ContactInformationFormatter implements IContactInformationFormatter {

	public void readContactInformation(String[] filePaths) {
		for(int i = 0; i < filePaths.length; i++)
		{	
			
		}
	}

	@Override
	public void formatContactInformation(String fileName) {
		FormatExceptionHandler handler = new FormatExceptionHandler();
		Scanner scan;
		try {
			File file = new File(filePaths[i]);
			scan = new Scanner(file);
		}catch(FileNotFoundException e) {
			handler.handleFileNotFoundException(e);
		}
		String name = scan.nextLine();
	}

	@Override
	public void formatEmail(String email) throws EmailAddressFormatException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void formatName(String name) throws NameFormatException {
		// TODO Auto-generated method stub
		
	}
}