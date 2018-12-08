package ch09_prj1_AnimalCounter;

public class AnimalCounterApp {

	public static void main(String[] args) {
		
		// welcome message
		System.out.println("Welcome to the Aperture Science Animal Counter \n");
		
			// create alli object
			Alligator alligators = new Alligator();
			Sheep sheep = new Sheep();
			
			// display alligators
			count(alligators, 3);
			
			// display sheepses
			count(sheep, 2);
			
			// create cloned sheepses
			
			try {
				Sheep sheep2 = (Sheep) sheep.clone();
				
				sheep2.setFirstName("dope");
				sheep2.setLastName("sheep");
				sheep2.getFullName();
				
				// display cloned sheepses
				count(sheep2, 3);
			}
			catch (CloneNotSupportedException ex) {
				System.out.println(ex);
			}
	}
	
	public static void count(Countable c, int maxCount) {
		String message = "";
		String animalType = "";
		int i = 0;
		
		if (c instanceof Alligator) {
			animalType = "alligators";
		
		} else if (c instanceof Sheep) {
			animalType = "sheep";
		}
		
		// overrides getCountString to return string specific to Alli
		System.out.println(c.getCountString());
		for (i = 1; i <= maxCount; i++) {
			
			message += i + " " + animalType + "\n";
		}
		System.out.println(message);
	}
}
