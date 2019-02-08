import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ContactManagerStreamsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
		List<Contact> contacts =  new ArrayList<>();
		
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		
		System.out.println("All Contacts:");
		contacts.stream().forEach(c -> System.out.println(c));
		
		System.out.println("Contacts with no phone:");
		contacts.stream()
		.filter(c -> c.getPhone() == null)
		.forEach(c -> System.out.println(c));
		
		List<Contact> cnp = contacts.stream()
				.filter(c -> c.getPhone() == null)
				.collect(Collectors.toList());
		System.out.println("There are " + cnp.size() + " with no phone number.");
		
		List<String> contactNames = contacts.stream()
				.map(Contact::getName)
				.collect(Collectors.toList());
		
		contactNames.stream()
		.forEach(System.out::println);
		
	}
}
