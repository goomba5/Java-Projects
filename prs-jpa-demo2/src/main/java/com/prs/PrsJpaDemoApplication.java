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
		
		// POSSIBLE ENHANCEMENTS:
		// give user the choice of displaying options user, vendor, 

			int o = 0;
		
			while(o != 22) {
				// present the menu
				getMenu();
				
				o = con.getInt("Enter Option: ");
				if(o == 1) {
					// get all vendors
					List<Vendor> vendors = VendorDB.getAll();
					for(Vendor v: vendors) {
						System.out.println("Vendor name: " + v.getName());
						System.out.println("Vendor phone number: " + v.getPhoneNumber());
						System.out.println("Vendor email: " + v.getEmail());
						System.out.println();
					}
				}
				else if(o == 2) {
					// get a vendor
					o = con.getInt("Enter vendor ID: ");
					
					Vendor vendor = VendorDB.getVendorById(o);
					
					System.out.println("Vendor ID: " + vendor.getId());
					System.out.println("Here is the information for " + vendor.getName());
					System.out.println("Location: " + vendor.getCity() + ", " + vendor.getState());
					System.out.println("Vendor phone number: " + vendor.getPhoneNumber());
					
					}
//				else if(o == 3) {
//					// get products by vendor ID
//					int vid = con.getInt("Enter vendor ID: ");
//					List<Product> products = ProductDB.getAllProductsByVendorID(vid);
//					for(Product p: products) {
//						System.out.println(p);
//					}
					
//				}
				else if (o == 3) {
					
					// add a vendor
					String code = con.getString("Enter new vendor code: ");
					String name = con.getString("Enter the name of the vendor: ");
					String address = con.getString("Enter the address: ");
					String city = con.getString("Enter the city: ");
					String state = con.getString("Enter the state: ");
					String zipCode = con.getString("Enter the zip code: ");
					String phoneNum = con.getString("Enter the phone number: ");
					String email = con.getString("Enter the email: ");
					
					Vendor vendor = new Vendor(0, code, name, address, city, state, zipCode, phoneNum, email);
					
					VendorDB.addVendor(vendor);
					
					System.out.println("The following vendor has been added: " + name);
					System.out.println("Vendor code: " + code);
				}
				else if (o == 4) {
					// delete a vendor
					o = con.getInt("Enter ID for vendor you want to delete: ");
					Vendor v = VendorDB.getVendorById(o);
					
					if(v == null) {
						System.out.println("No vendor");
					}
					else {
						if(VendorDB.deleteVendor(v)) {
							System.out.println("Vendor successfully deleted");
						}
						else {
							System.out.println("Error deleting vendor");
						}
					}
				}
				else if(o == 5) {
					
					// get all users
					List<User> users = UserDB.getAll();
					for(User u: users) {
						String fullName = u.getFirstName() + " " + u.getLastName();
						System.out.println("User ID: " + u.getId());
						System.out.println("Name: " + fullName);
						System.out.println("Username: " + u.getUserName());
						System.out.println("Email: " + u.getEmail());
						System.out.println();
					}
				}
				else if(o == 6) {
					// get a user
					o = con.getInt("Enter user ID: ");
					
					User user = UserDB.getUserById(o);
					
					System.out.println(user.getFirstName() + " " + user.getLastName());
					}
				else if(o == 7) {
					
					// add a user
					String userName = con.getString("Enter new username: ");
					String password = con.getString("Enter new password: ");
					String firstName = con.getString("Enter first name: ");
					String lastName = con.getString("Enter last name: ");
					String phoneNum = con.getString("Enter phone number: ");
					String email = con.getString("Enter email: ");
					
					String fullName = firstName + " " + lastName;
					
					User user = new User(0, userName, password, firstName, lastName, phoneNum, email);
					
					UserDB.addUser(user);
					
					System.out.println("The following user has been added: " + fullName);
					
				}
				else if(o == 8) {
					// update user
					List<User> users = UserDB.getAll();
					UserDB udb = new UserDB();
					// update user
					o = con.getInt("Enter ID for user: ");
					
					for(User u: users) {
						if(o == u.getId()) {
							String newEmail = con.getString("Enter new email for " + u.getFirstName() + ": ");
							u.setEmail(newEmail);
							if(udb.updateUser(u)) {
								System.out.println("The email for " + u.getFirstName() + " has been updated.");
							}
						}
					}
				}
				else if (o == 9) {
					// delete a user
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
				else if(o == 10) {
					// get all products
					List<Product> products = ProductDB.getAll();
					for(Product p: products) {
						System.out.println("Product name: " + p.getName());
						System.out.println("Product ID: " + p.getPartNumber());
						
						System.out.println(); // new line for space
					}
				}
				else if(o == 11) {
					// get a product by ID
					o = con.getInt("Enter product ID: ");
					
					Product product = ProductDB.getProductById(o);
					
					System.out.println("Product name: " + product.getName());
					System.out.println("Product ID: " + product.getPartNumber());
				}
				else if(o == 12) {
					// add a product
					String partNumber = con.getString("Enter new part number: ");
					String name = con.getString("Enter product name: ");
					double price = con.getDouble("Enter the price: ");
					String unit = con.getString("Enter unit: ");
					String photoPath = con.getString("Enter photo path: ");
					
					Product product = new Product(0, 0, partNumber, name, price, unit, photoPath);
					
					ProductDB.addProduct(product);
					
					System.out.println("The following product has been added: " + name);
				}
				else if (o == 13) {
					// delete a product
					o = con.getInt("Enter ID for product you want to delete: ");
					Product p = ProductDB.getProductById(o);
					
					if(p == null) {
						System.out.println("No product");
					}
					else {
						if(ProductDB.deleteProduct(p)) {
							System.out.println("Product successfully deleted");
						}
						else {
							System.out.println("Error deleting product");
						}
					}
				}
				else if(o == 14) {
					// get all PRs
					List<PurchaseRequest> purchaseReq = PurchaseRequestDB.getAll();
					for(PurchaseRequest p: purchaseReq) {
						System.out.println("Purchase Request Identification: " + p.getId());
						System.out.println("Description: " + p.getDescription());
						System.out.println("Justification: " + p.getJustification());
						System.out.println("Delivery Mode: " + p.getDeliveryMode());
					}
				}
				else if(o == 15) {
					// get purchase request
					o = con.getInt("Enter purchase request ID: ");
					
					PurchaseRequest pr = PurchaseRequestDB.getPurchaseRequestById(o);
					
					System.out.println(pr);
				}
				else if(o == 16) {
					// add new purchase request
					String description = con.getString("Enter description: ");
					String justification = con.getString("Enter justification: ");
					String dateNeeded = con.getString("Enter date needed: ");
					String deliveryMode = con.getString("Enter the delivery mode: ");
					String status = con.getString("Enter the status: ");
					double total = con.getDouble("Enter the total: ");
					String unit = con.getString("Enter unit: ");
					String photoPath = con.getString("Enter photo path: ");
					
					PurchaseRequest pr = new PurchaseRequest(0, 0, description, justification, dateNeeded, 
										 deliveryMode, status, total, unit, photoPath);
					
					PurchaseRequestDB.addPurchaseRequest(pr);
					
					System.out.println("Your new purchase request has been added.");
				}
				else if (o == 17) {
					// delete purchase request
					o = con.getInt("Enter ID for the PR ID you want to delete: ");
					PurchaseRequest p = PurchaseRequestDB.getPurchaseRequestById(o);
					
					if(p == null) {
						System.out.println("No purchase request found.");
					}
					else {
						if(PurchaseRequestDB.deletePR(p)) {
							System.out.println("Purchase request successfully deleted");
						}
						else {
							System.out.println("Error deleting purchase request");
						}
					}
				}
				else if (o == 18) {
					// get all PRLIs
					List<PurchaseRequestLineItem> purchaseLine = PurchaseLineItemDB.getAll();
					for(PurchaseRequestLineItem p: purchaseLine) {
						System.out.println("Purchase Line Item ID: " + p.getId());
						System.out.println("Quantity: " + p.getQuantity());
						System.out.println("Purchase Code: " + p.hashCode());
					}
				}
				else if(o == 19) {
					o = con.getInt("Enter purchase request line item ID: ");
					
					PurchaseRequestLineItem prli = PurchaseLineItemDB.getPRLIById(o);
					
					System.out.println(prli);
				}
				else if(o == 20) {
					// add new purchase line item
					int quantity = con.getInt("Enter quantity: ");
					
					PurchaseRequestLineItem prli = new PurchaseRequestLineItem(0, 0, 0, quantity);
					
					PurchaseLineItemDB.addPRLI(prli);
					
					System.out.println("Your new purchase request has been added.");
				}
				else if(o == 21) {
					// delete purchase request line item
					o = con.getInt("Enter ID for the purchase request line item you want to delete: ");
					PurchaseRequestLineItem p = PurchaseLineItemDB.getPRLIById(o);
					
					if(p == null) {
						System.out.println("No purchase request line item found.");
					}
					else {
						if(PurchaseLineItemDB.deletePRLI(p)) {
							System.out.println("PRLI successfully deleted");
						}
						else {
							System.out.println("Error deleting purchase request line item");
						}
					}
				}
			}
			System.out.println("GET OUT! GET OUT NOW!");
		}
	
		private static void getMenu() {
			System.out.println(); // new line for space
			System.out.println("VENDOR OPTIONS");
			System.out.println("1 - View All Vendors");
			System.out.println("2 - Get a Vendor");
			System.out.println("3 - Add a Vendor");
			System.out.println("4 - Delete a Vendor");
			
			System.out.println();
			System.out.println("USER OPTIONS");
			System.out.println("5 - View All Users");
			System.out.println("6 - Get a User");
			System.out.println("7 - Add a User");
			System.out.println("8 - Update User Email Address");
			System.out.println("9 - Delete a User");
			
			System.out.println();
			System.out.println("PRODUCT OPTIONS");
			System.out.println("10 - View All Products");
			System.out.println("11 - Get a Product");
			System.out.println("12 - Add a Product");
			System.out.println("13 - Delete a Product");
			
			System.out.println();
			System.out.println("PURCHASE REQUEST OPTIONS");
			System.out.println("14 - View All Purchase Requests");
			System.out.println("15 - Get a Purchase Request");
			System.out.println("16 - Add a Purchase Request");
			System.out.println("17 - Delete a Purchase Request");
			
			System.out.println();
			System.out.println("PURCHASE LINE ITEM OPTIONS");
			System.out.println("18 - View All Purchase Line Items");
			System.out.println("19 - Get a Purchase Line Item");
			System.out.println("20 - Add a Purchase Line Item");
			System.out.println("21 - Delete a Purchase Line Item");
			
			System.out.println("22 - Exit PRS System");
		}
	}

