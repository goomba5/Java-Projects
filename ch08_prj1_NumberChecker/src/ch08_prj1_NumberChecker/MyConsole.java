package ch08_prj1_NumberChecker;

public class MyConsole extends Console {
	
	
	public MyConsole() {
		
	}
	
	public String numberCheck(int integer) {
		String oddEven = "odd";
		String str = "";
		
		if (integer % 2 == 0) {
			oddEven = "even";
		}
		return str = "The number " + integer + " is " + oddEven + ".";
		
	}
	
	@Override
	public String getString(String prompt) {
		boolean isValid = false;
		String str = "";

		while (!isValid) {
			System.out.print(prompt);
			str = sc.nextLine();
			if (str.equals("")) {
				System.out.println("Input is required. Please enter a valid integer.");
				isValid = false;
			}
			else {
				isValid = true;
			}
		}
		return str;
	}
}
