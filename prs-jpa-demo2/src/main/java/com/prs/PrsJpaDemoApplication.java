package com.prs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import business.Product;
import business.ProductDB;
import business.PurchaseRequestLineItem;
import business.PurchaseLineItemDB;
import business.PurchaseRequest;
import business.PurchaseRequestDB;
import business.User;
import business.UserDB;
import business.Vendor;
import business.VendorDB;
import util.Console;

public class PrsJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemoApplication.class, args);
		
		Console con = new Console();
		
		System.out.println("Hello, Spring Boot!");
		// POSSIBLE ENHANCEMENTS:
		// create choice for user to select options specific to user, vendor or products

			int o = 0;
		
			while(o != 11) {
				// present the menu
				getMenu();
				
				o = con.getInt("Enter Option: ", 0, 12);
				if(o == 1) {
					// get all users
					List<Vendor> vendors = VendorDB.getAll();
					for(Vendor v: vendors) {
						System.out.println("Vendor name: " + v.getName());
						System.out.println("Vendor phone number: " + v.getPhoneNumber());
						System.out.println("Vendor email: " + v.getEmail());
						System.out.println();
					}
				}
				else if(o == 2) {
					o = con.getInt("Enter vendor ID: ");
					
					Vendor vendor = VendorDB.getVendorById(o);
					
					System.out.println("Vendor ID: " + vendor.getId());
					System.out.println("Here is the information for " + vendor.getName());
					System.out.println("Location: " + vendor.getCity() + ", " + vendor.getState());
					System.out.println("Vendor phone number: " + vendor.getPhoneNumber());
					
					}
				else if(o == 3) {
					// add a vendor
					
				}
				else if(o == 4) {
					
					// get all users
					List<User> users = UserDB.getAll();
					for(User u: users) {
						String fullName = u.getFirstName() + " " + u.getLastName();
						System.out.println("Name: " + fullName);
						System.out.println("Username: " + u.getUserName());
						System.out.println("Email: " + u.getEmail());
						System.out.println();
					}
				}
				else if(o == 5) {
					o = con.getInt("Enter user ID: ");
					
					User user = UserDB.getUserById(o);
					
					System.out.println(user.getFirstName() + " " + user.getLastName());
					}
				else if(o == 6) {
					// add a user
				}
				else if (o == 7) {
					o = con.getInt("Enter ID for user you want to delete: ");
					User u = UserDB.getUserById(o);
					
					if(u == null) {
						System.out.println("No user");
					}
					else {
						if(UserDB.deleteUser(u)) {
							System.out.println("User successfully deleted");
						}
						else {
							System.out.println("Error deleting user");
						}
					}
				}
				else if(o == 8) {
					// get all products
					List<Product> products = ProductDB.getAll();
					for(Product p: products) {
						System.out.println("Product name: " + p.getName());
						System.out.println("Product ID: " + p.getPartNumber());
						System.out.println("Vendor: " + p.getVendor().getName());
						System.out.println("Vendor Email: " + p.getVendor().getEmail());
						
						System.out.println(); // new line for space
					}
				}
				else if(o == 9) {
					// get all users
					List<PurchaseRequest> purchaseReq = PurchaseRequestDB.getAll();
					for(PurchaseRequest p: purchaseReq) {
						System.out.println("Purchase Request Identification: " + p.getId());
						System.out.println("Description: " + p.getDescription());
						System.out.println("Justification: " + p.getJustification());
						System.out.println("Delivery Mode: " + p.getDeliveryMode());
					}
				}
				else if (o == 10) {
					// get all users
					List<PurchaseRequestLineItem> purchaseLine = PurchaseLineItemDB.getAll();
					for(PurchaseRequestLineItem p: purchaseLine) {
						System.out.println("Purchase Line Item ID: " + p.getId());
						System.out.println("Product Name: " + p.getProduct().getName());
						System.out.println("Quantity: " + p.getQuantity());
						System.out.println("Purchase Code: " + p.hashCode());
					}
				}
			}
			System.out.println("GET OUT! GET OUT NOW!");
		}
	
		private static void getMenu() {
			System.out.println(); // new line for space
			System.out.println("1 - View All Vendors");
			System.out.println("2 - Get A Vendor");
			System.out.println("3 - Add A Vendor");
			System.out.println("4 - View All Users");
			System.out.println("5 - Get A User");
			System.out.println("6 - Add A User");
			System.out.println("7 - Delete A User");
			System.out.println("8 - View All Products");
			System.out.println("9 - View All Purchase Requests");
			System.out.println("10 - View All Purchase Line Items");
			System.out.println("11 - Exit PRS System");
		}
	}

