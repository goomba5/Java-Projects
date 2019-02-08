import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ContactManagerPredicateInterfaceApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
		List<Contact> contacts =  new ArrayList<>();
		
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		
		System.out.println("All Contacts:");
		printContactSummary(contacts);
		
		List<Contact> cnp = filterContacts(contacts, c -> c.getPhone() == null);
		
		
		List<Contact> cne = filterContacts(contacts, c -> c.getEmail() == null);
		
		System.out.println("Contacts without phone...");
		printContactSummary(cnp);
		
		System.out.println("Contacts without email...");
		printContactSummary(cne);
		
		System.out.println("Goodbye!");
	}

	private static void printContactSummary(List<Contact> contacts) {
		System.out.println("Contact Summary:");
		for(Contact c: contacts) {
			System.out.println(c);
		}
	}
	
	private static List<Contact> filterContacts(List<Contact> contacts, Predicate<Contact> condition){
		List<Contact> filteredContacts = new ArrayList<Contact>();
		
		for(Contact c: contacts) {
			if(condition.test(c)) {
				filteredContacts.add(c);
			}
		}
		
		return filteredContacts;
	}
}
