package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import business.Customer;

public class CustomerDB {
	private Connection getConnection() throws SQLException {
		
		String dbURL = "jdbc:mysql://localhost:3306/mma";
		String username = "customer_user";
		String password = "sesame";
		Connection connection = DriverManager.getConnection(dbURL,
								username, password);
		return connection;
	} // Connection closing brace
	
	public List<Customer> getCustomers() throws SQLException {
		List<Customer> customer = new ArrayList<>();
		
		Connection connect = getConnection();
		Statement statement = connect.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM Customer");
		
		while(rs.next()) {
				
				// process each of the customers
				int customerID = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				Customer c = new Customer(customerID, firstName, lastName, email);
				
				// add the customer to the list
				customer.add(c);
		}
		return customer;
	} // getCountries brace
}
