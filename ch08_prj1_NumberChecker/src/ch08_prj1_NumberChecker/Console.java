package ch08_prj1_NumberChecker;

import java.util.Scanner;

public class Console {
	
	public Console() {
		
	}
	
	protected Scanner sc = new Scanner(System.in);
	
	public String getString(String prompt) {
		System.out.print(prompt);
		String s = sc.next();
		sc.nextLine();
		return s;
	}
	
	public int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		
		while(!isValid) {
			System.out.print(prompt);
			
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			}
			else {
				System.out.println("Error! Invalid integer. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}
}
