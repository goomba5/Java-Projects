package ch07_prj2_GradeConverter;

public class Grade {
	
	private int number;
	private String letter;
	
	public Grade() {
		super();
		this.number = 0;
		this.letter = letter;
	}
	
	public Grade(int number) {
		super();
		this.number = number;
		this.letter = letter;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	
	public String getLetter() {
		 if(number > 88 && number <= 100) {
		    letter = "A";
		 } else if (number >= 80 && number <= 87) {
		    letter = "B";
	        
	    } else if (number > 67 && number <= 79) {
	    	letter = "C";
	        
	    } else if (number > 60 && number <= 67) {
	    	letter = "D";
	        
	    } else if (number < 60){
	        letter = "F";
	    }
		return letter;
	}
}
