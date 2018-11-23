package ch05_prj1_DiceRoller;

import java.util.Scanner;

public class DiceRollerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// display welcome message
		System.out.println("Welcome to the Aperture Science Dice Roller Application!");
//		System.out.println(); // new line for space
		
		// create scanner
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		//create while loop
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {
			System.out.println(); // new line for space
			
			// enter your static method here
			rollDice();
			
			System.out.println(); // new line for space
			
		// continue
		System.out.print("Roll again? (y/n) ");
		choice = sc.next();
		}
		// goodbye
		goodbye();
	}


private static String rollDice () {

	// create for loop
		int i = 0;
		int roll = 0;
		int total = 0;
		String dice = " ";
		String specialMsg = "";
		String message = "";
		
		for (i = 1; i <= 2; i++) {
			roll = (int) (Math.random() * 6) + 1;
			total += roll;
			dice = "Dice " + i + ": " + roll;
			
			
			if (i == 2 && total <= 2) {
				specialMsg = "Snake eyes!" + "\n";
			} else if (total == 12){
				specialMsg = "Box car!" + "\n";
			}
			
			System.out.println(dice);
			
		}
		System.out.println("Total: " + total);
		System.out.print(specialMsg);		
		
		return message;

	}

public static void goodbye() {
//	System.out.println(); // new line for space
	System.out.print("Thank you for using the Aperture Science Dice Roller." +
					"\n" + "Goodbye!");
}

}




