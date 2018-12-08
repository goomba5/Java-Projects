package ch09_prj1_AnimalCounter;

public class Sheep extends Animal implements Cloneable {
	
	private String firstName;
	private String lastName;
	private String fullName;
	
	public Sheep() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		
		return firstName + " " + lastName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String getCountString() {
		String message = "Counting sheep... \n";
			
		return message;
		}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone(); 
		} 
		
	}
