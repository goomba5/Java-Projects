package ch09_prj2_AccountBalanceCalculator;

public class AccountBalanceApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// welcome message
		System.out.println("Welcome to the Aperture Science Account Balance Calculator \n");
		
		// set starting balances
		
		CheckingAccount check = new CheckingAccount(1.0);
		check.setBalance(1000.00);
		
		SavingsAccount savings = new SavingsAccount(0.01);
		System.out.println("Starting Balances");
		savings.setBalance(1000.00);
		
		//display balances using static method
		displayBalances(check, savings);
		
		// prompt the user for entries
		System.out.println(); // new line for space
		System.out.println("Enter the transactions for the month \n");
		
		// create console object
		Console console = new Console();
		
		// create choice variable
		String choice = "y";
		
		// create while loop
		while (choice.equalsIgnoreCase("y")) {
			String transaction = console.getString("Withdrawal or deposit? (w/d) ");
			String accountType = console.getString("Checking or savings? (c/s) ");
			double amount = console.getDouble("Amount: ");
			
			// balances
			Account account = null;
			if (accountType.equalsIgnoreCase("c")) {
				account = check;
			}
			else {
				account = savings;
			}
			
			if (transaction.equalsIgnoreCase("w")) {
				account.withdraw(amount);
			}
			else {
				account.deposit(amount);
			}
			
			
		// continue
		System.out.println(); // new line for space
		choice = console.getString("Continue? (y/n) ");
		}
		
		// display monthly payments and fees
		check.subtractMonthlyFeeFromBalance();
		savings.applyPayToBalance();
		
		System.out.println(); // new line for space
		System.out.println("Monthly Payments and Fees");
		System.out.println("Checking fee:             " + check.getMonthlyFee());
		System.out.println("Savings interest payment: " + savings.getMonthlyInterestPayment());
		
		System.out.println();
		System.out.println("Final Balances");
		displayBalances(check, savings);
		
		//goodbye
		System.out.println(); // new line for space
		System.out.println("Thank you for using the Aperture Science Account Balance Calculator\n" + "Goodbye!");
		
	}
	private static void displayBalances(CheckingAccount check, SavingsAccount savings) {
		System.out.println("Checking: " + check.getBalance());
		System.out.println("Savings: " + savings.getBalance());
	}

}
