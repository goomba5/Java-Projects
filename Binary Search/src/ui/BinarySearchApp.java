package ui;

import java.util.Scanner;

import util.Console;

public class BinarySearchApp {

	public static void main(String[] args) {
		
		// welcome message
		System.out.println("Welcome to Arcite's Guessing Game!\n");
		
		// console object
		Console console = new Console();
		Scanner sc = new Scanner(System.in);
		
		// choice variable
		String choice = "y";
		
		// array list
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		
		// brief description
		System.out.println("Shaxx: \"Guardian! Arcite is making me guess numbers." + 
						   "I'm not fond of his little game." +
						   "\n" + "\"Help me so I can continue watching the Crucible.\"");
		
		System.out.println(); // new line for space
		
		
		
		// create continue loop
		while(choice.equalsIgnoreCase("y")) {
			int lowNum = 0;
			int highNum = numbers.length - 1;
			int arciteChoice = (int) (Math.random() * numbers.length) + 1;
			int counter = 0;
			int counterMax = 5;
			
			System.out.println("Arcite: \"You get " + counterMax + " guesses, Guardian.\"");
			
			// create binary search loop
			while(lowNum <= highNum) {
				
				if (counterMax < 2) {
					System.out.println("Arcite: \"You have " + counterMax + " guess left.\"");
				}
				else {
					System.out.println("Arcite: \"You have " + counterMax + " guesses left.\"");
				}
				
				counter++;
				counterMax -= 1;
				
				String str = "Arcite: \"Well done, Guardian! My number of choice was " + 
							 arciteChoice + ".\"\n";
				String str1 = " ";
				
				int guess = console.getInt(sc,"Arcite: \"Pick a number\": ");
				
				if(guess == arciteChoice) {
					
					if(counter < 2) {
						str1 = "Arcite: \"That only took you one guess, Guardian! Well done!\"";
						System.out.println(str + str1);
					}
					else {
						str1 = "Arcite: \"That took you " + counter + " guesses.\"";
						System.out.println(str + str1);
					}
					break;
				}
				
				else if (counterMax == 0) {
					str1 = "Arcite: \"I'm sorry, Guardian. All " + counter + 
						   " guesses have been used.\n" +
						   "I chose the number " + arciteChoice + ".";
					System.out.println(str1);
					break;
				}
				
				else if(guess > arciteChoice) {
					highNum = guess - 1;
					str = "Arcite: \"That is too high, Guardian.\"";
					System.out.println(str);
					
				}
				
				else if (guess < arciteChoice) {
					lowNum = guess + 1;
					str = "Arcite: \"Much too low, Guardian. Try again.\"";
					System.out.println(str);
				}
			}
			System.out.println(); // new line for space
			choice = console.getString("Arcite: \"Would you like to play again?\" (y/n) ");
		}
		System.out.println(); // new line for space
		System.out.println("Arcite: \"Thank you for playing, Guardian." + 
									 " Shaxx is a terrible guesser.\"" +
									 "\nShaxx: \"Back to the Crucible, Guardian!\"");

	}

}
