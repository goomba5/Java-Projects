package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.Country;

public class CountryDB {
	
	private Connection getConnection() throws SQLException{

		String dbURL = "jdbc:mysql://localhost:3306/mma";
		String username = "country_user";
		String password = "sesame";
		Connection connection = DriverManager.getConnection(dbURL,
								username, password);
		return connection;
	} // getConnection brace
	
	public List<Country> getCountries() throws SQLException {
		List<Country> country = new ArrayList<>();
		
		Connection connect = getConnection();
		Statement statement = connect.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM Country");
		
		while(rs.next()) {
				
				// process a stuffy
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Country c = new Country(id, name);
				
				// add the stuffy to the list
				country.add(c);
		}
		return country;
	} // getCountries brace
	
	public boolean addCountry(Country c) throws SQLException{
		
		Connection connect = getConnection();
		boolean successful = false;
		
		// create SQL query string
		String query = "INSERT INTO Country" +
				   "(id, name)" +
				   "VALUES('"+ c.getId()+ "', '"+c.getName()+"')";
		
		Statement statement = connect.createStatement();
		int rowCount = statement.executeUpdate(query);
		
		if(rowCount > 0) {
			successful = true;
		}
		
		
		return successful;
	} // addCountry brace
} // class brace
