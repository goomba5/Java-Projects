package ch07_prj1_ContactList;

public class ContactDB {
	
	public static String getContactList() {
		String names = " ";

		// display contacts
		names=  "Current list of contacts:\n" +
				"-" + " gary" + "\n" +
				"-" + " mike" + "\n" +
				"-" + " sean" + "\n" +
				"-" + " gordon" + "\n" +
				"-" + " glados" + "\n";
		
		return names;
	}
	
	public static Contact getContact(String firstName) {
	
	// create Contact object
	Contact contact = new Contact();
	
	// fill the Contact object with data
	    contact.setFirstName(firstName);
	    if(firstName.equalsIgnoreCase("gary")) {
	    	contact.setFirstName("Gary");
	        contact.setLastName("Henderson");
	        contact.setEmail("sonicdahedgehog@juno.com");
	        contact.setPhoneNumber("513-235-8725");
	    } else if (firstName.equalsIgnoreCase("mike")) {
	    	contact.setFirstName("Mike");
	        contact.setLastName("Murach");
	        contact.setEmail("mike@murachbooks.com");
	        contact.setPhoneNumber("800-568-0044");
        
	    } else if (firstName.equalsIgnoreCase("sean")) {
	    	contact.setFirstName("Sean");
	        contact.setLastName("Blessing");
	        contact.setEmail("sean@seanblessing.com");
	        contact.setPhoneNumber("513-347-1111");
	        
	    } else if (firstName.equalsIgnoreCase("gordon")) {
	    	contact.setFirstName("Gordon");
	        contact.setLastName("Freeman");
	        contact.setEmail("gfreeman@blackmesa.org");
	        contact.setPhoneNumber("xxx-xxx-xxxx");
	        
	    } else if (firstName.equalsIgnoreCase("glados")) {
	    	contact.setFirstName("GLaDOS");
	    	contact.setLastName("");
	        contact.setEmail("neurotoxin@thecakeisalie.org");
	        contact.setPhoneNumber("xxx-xxx-xxxx"); 
	    } else {
	        contact.setFirstName("Unknown");
	    }
	    return contact;
	}
}
