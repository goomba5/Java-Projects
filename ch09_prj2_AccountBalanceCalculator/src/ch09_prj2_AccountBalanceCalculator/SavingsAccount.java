package ch09_prj2_AccountBalanceCalculator;

public class SavingsAccount extends Account {
	
	private double monthlyInterestRate;
	private double monthlyInterestPayment;
	
	public SavingsAccount(double monthlyInterestRate) {
		super();
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public double getMonthlyInterestPayment() {
		return monthlyInterestPayment;
	}

	public void setMonthlyInterestPayment(double monthlyInteresetPayment) {
		this.monthlyInterestPayment = monthlyInteresetPayment;
	}
	
	public void applyPayToBalance() {
		setMonthlyInterestPayment(getBalance() * monthlyInterestRate);
		setBalance(getBalance() + monthlyInterestPayment);
	}
	
	
	
}
