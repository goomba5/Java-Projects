package ch03_prj3_InterestCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// display welcome message
		System.out.println("Welcome to the Interest Calculator");
		
		// create scanner class
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		// create choice variable
		String choice = "y";
		
		// create program loop
		while(choice.equalsIgnoreCase("y")) {
			
			// prompt user for loan amount and interest rate
			System.out.println(); // new line
			System.out.print("Enter the loan amount: ");
			double loanInput = sc.nextDouble();
			
			//prompt user for the interest rate
			System.out.print("Enter the interest rate: ");
			double interestInput = sc.nextDouble();
			System.out.println(); // new line
			
				// create BigDecimal variables for calculation
				BigDecimal bigLoan = new BigDecimal(loanInput);
				BigDecimal bigInterest = new BigDecimal(interestInput);
				
				// calculate the interest amount
				BigDecimal interestAmount = bigLoan.multiply(bigInterest)
						.setScale(2, RoundingMode.HALF_UP);
				
				// format the loan, interest rate and interest
				
					// format for loan (currency)
					NumberFormat currency = NumberFormat.getCurrencyInstance();
					String loanString = currency.format(bigLoan);
					
					// format for percentage (percent)
					NumberFormat percentage = NumberFormat.getPercentInstance();
					String interestRateString = percentage.format(bigInterest);
				
					// format for interest amount (currency)
					NumberFormat interest = NumberFormat.getCurrencyInstance();
					String interestString = interest.format(interestAmount);
					
				// display results
				System.out.println("Loan amount: " + loanString);
				System.out.println("Interest rate: " + interestRateString);
				System.out.println("Loan amount: " + interestString);
				System.out.println(); // new line
				
				// continue?
				System.out.print("Continue? (y/n) ");
				choice = sc.next();
		}
			// goodbye
			System.out.print("Thank you for using the Interest Calculator App." + 
			"\n" + "Goodbye!");
	}

}
