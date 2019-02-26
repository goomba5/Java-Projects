import java.util.ArrayList;

public class FieldCountTotalApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// list of docs in docspot project1
		ArrayList<Document> project1 = new ArrayList<>();
		project1.add(new Document(0, 8, 3, "Addendum to Exclusive Right to Lease"));
		project1.add(new Document(2, 250, 30, "Seller's Disclosure"));
		project1.add(new Document(3, 5, 5,  "Home Warranty Pamphlet"));
		project1.add(new Document(4, 200, 15, "Exclusive Right to Sell Agreement"));
		project1.add(new Document(5, 856, 35, "FMLS Residential Input Sheet"));
		
		// list of docs in docspot project2
		ArrayList<Document> project2 = new ArrayList<>();
		project2.add(new Document(0, 8, 2, "Addendum to Exclusive Right to Lease"));
		project2.add(new Document(2, 250, 45, "Seller's Disclosure"));
		project2.add(new Document(3, 5, 10,  "Home Warranty Pamphlet"));
		project2.add(new Document(4, 200, 15, "Exclusive Right to Sell Agreement"));
		project2.add(new Document(5, 856, 60, "FMLS Residential Input Sheet"));
		
		// print doc names for project1
		System.out.println("Project 1 Documents:");
		for(Document d: project1) {
			System.out.println(d.getName());
		}
		
		// calculate total time for project 1
		int total = getTotalTime(project1);
		
		// display total
		System.out.println();
		System.out.println("The total time for the project was " + total + " minute(s).");
		
		// print doc names for project1
		System.out.println();
		System.out.println("Project 2 Documents:");
		for(Document d: project2) {
			System.out.println(d.getName());
		}
		
		// calculate total time for project 2
		int total1 = getTotalTime(project2);
		
		// calculate field count total
		int fieldTotal = getTotalFields(project2);
		
		// display total
		System.out.println();
		System.out.println("Total fields: " + fieldTotal);
		System.out.println("The total time for the project was " + total1 + " minute(s).");
	}
	
	public static int getTotalTime(ArrayList<Document> docs) {
		int total = 0;
		for(Document d: docs) {
			total += d.getTime();
		}
		return total;
	}
	
	public static int getTotalFields(ArrayList<Document> docs) {
		int total = 0;
		for(Document d: docs) {
			total += d.getFields();
		}
		return total;
	}

}
