package util;

import java.util.Scanner;

public class Console {
	
	Scanner sc = new Scanner(System.in);
	
	public String getString(String prompt) {
		boolean isValid = false;
		String i = "";
		
		while(!isValid) {
			System.out.print(prompt);
			if(i.equals("")) {
				i = sc.next();
				isValid = true;
			}
			else {
				System.out.println("Invalid entry. Please enter either y or n.");
				isValid = false;
				sc.nextLine();
			}
		}
		return i;
	}
	
	public int getInt(Scanner sc, String prompt) {
		boolean isValid = false;
		int i = 0;
		
		while(!isValid) {
			System.out.print(prompt);
			if(sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			}
			else {
				System.out.println("Invalid entry. Please enter a valid integer.");
				isValid = false;
				sc.nextLine();
			}
		}
		return i;
	}
}
