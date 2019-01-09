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
	}
	
	public boolean addCustomer(Customer c) throws SQLException{
		
		Connection connect = getConnection();
		boolean successful = false;
		
		// create SQL query string
		String query = "INSERT INTO Customer" +
				   "(CustomerID, FirstName, LastName, EmailAddress)" +
				   "VALUES('" + c.getId() + "', '"+ c.getFirstName() + "', '" 
				   			  + c.getLastName() + "', '"+ c.getEmail() + "')";
		
		Statement statement = connect.createStatement();
		int rowCount = statement.executeUpdate(query);
		
		if(rowCount > 0) {
			successful = true;
		}
		
		
		return successful;
	}
	
	public boolean deleteCustomer(Customer c) throws SQLException {
			Connection connect = getConnection();
			boolean successful = false;
			
			String query = "DELETE FROM Customer WHERE EmailAddress = '" + c.getEmail()+ "'";
			Statement statement = connect.createStatement();
			int rowCount = statement.executeUpdate(query);
			
			if(rowCount > 0) {
				successful = true;
			}
			
			
			return successful;
		}
	}
