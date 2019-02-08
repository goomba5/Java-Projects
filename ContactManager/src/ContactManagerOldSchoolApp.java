import java.util.ArrayList;
import java.util.List;

public class ContactManagerOldSchoolApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
		List<Contact> contacts =  new ArrayList<>();
		
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		
		System.out.println("All Contacts:");
		printContactSummary(contacts);
		
		List<Contact> cnp = filterContactsWithoutPhone(contacts);
		List<Contact> cne = filterContactsWithoutEmail(contacts);
		
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
	
	private static List<Contact> filterContactsWithoutPhone(List<Contact> contacts){
		List<Contact> contactsNoPhone = new ArrayList<Contact>();
		
		for(Contact c: contacts) {
			if(c.getPhone() == null) {
				contactsNoPhone.add(c);
			}
		}
		
		return contactsNoPhone;
	}

	private static List<Contact> filterContactsWithoutEmail(List<Contact> contacts){
		List<Contact> contactsNoEmail = new ArrayList<Contact>();
		
		for(Contact c: contacts) {
			if(c.getEmail() == null) {
				contactsNoEmail.add(c);
			}
		}
		return contactsNoEmail;
	}
}
