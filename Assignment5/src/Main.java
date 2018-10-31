import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char x = ' ';
		char[] y;
		String[] z;

		try {
			File theFile = new File("CourseFile.txt");
			Scanner inFile = new Scanner(theFile);
			while (inFile.hasNext()) {
				String name = inFile.nextLine();
				name.length();
				x = name.charAt(2);
				y = name.toCharArray();
				z = name.split(",");
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File could not be found.");
		}

		System.out.println("It is " + x);

		String[] filePaths = { "testcase1.txt", "testcase2.txt", "testcase3.txt", "testcase4.txt", "testcase5.txt",
				"testcase6.txt", "testcase7.txt", "testcase8.txt", "testcase9.txt", "testcase10.txt" };
		ContactInformationFormatter formatter = new ContactInformationFormatter();
		formatter.readContactInformation(filePaths);
		System.out.println("Partner 2 change");
		System.out.println("Richard");
	}
}