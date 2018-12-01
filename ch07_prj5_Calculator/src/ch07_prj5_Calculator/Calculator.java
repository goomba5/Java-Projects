package ch07_prj5_Calculator;

public class Calculator {
	
	private int menuNum;
	
	private int intNum1;
	private int intNum2;
	private int intNum3;
	
	private double dblNum1;
	private double dblNum2;
	private double dblNum3;
	
	public Calculator() {
		super();
	}
	
	public int getMenuNum() {
		return menuNum;
	}

	public int getIntNum1() {
		return intNum1;
	}

	public void setIntNum1(int intNum1) {
		this.intNum1 = intNum1;
	}

	public int getIntNum2() {
		return intNum2;
	}

	public void setIntNum2(int intNum2) {
		this.intNum2 = intNum2;
	}

	public int getIntNum3() {
		return intNum3;
	}

	public void setIntNum3(int intNum3) {
		this.intNum3 = intNum3;
	}
	
	
	public double getDblNum1() {
		return dblNum1;
	}

	public void setDblNum1(double dblNum1) {
		this.dblNum1 = dblNum1;
	}

	public double getDblNum2() {
		return dblNum2;
	}

	public void setDblNum2(double dblNum2) {
		this.dblNum2 = dblNum2;
	}

	public double getDblNum3() {
		return dblNum3;
	}

	public void setDblNum3(double dblNum3) {
		this.dblNum3 = dblNum3;
	}

	public double getSum(double dblNum1, double dblNum2) {
		double sum = dblNum1 + dblNum2;
			
		return sum;
	}
	
	public double getSum(double dblNum1, double dblNum2, double dblNum3) {
		double sum = dblNum1 + dblNum2 + dblNum3;
		
		return sum;
	}
	
	public int getSum(int intNum1, int intNum2) {
		int sum = intNum1 + intNum2;
			
		return sum;
	}
	
	public int getSum(int intNum1, int intNum2, int intNum3) {
		int sum = intNum1 + intNum2 + intNum3;
		
		return sum;
	}
	
	public String getMenu() {
		
		String menu =   "Choose the menu option you'd like to run" + "\n\n" +
						"1 - Sum of Two Integers" + "\n" +
						"2 - Sum of Three Integers" + "\n" +
						"3 - Sum of Two Doubles" + "\n" +
						"4 - Sum of Three Doubles" + "\n" +
						"5 - Exit the Aperture Science App" + "\n";
		
		return menu;
	}
	
	
}
