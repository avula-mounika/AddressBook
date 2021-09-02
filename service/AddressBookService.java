package com.bl.service;

import java.util.ArrayList;

import java.util.Scanner;

import com.bl.model.AddressBookModel;

public class AddressBookService {
	// method to add address book model in array list
	static ArrayList<AddressBookModel> addressBookModels = new ArrayList<>(); 
		// scanner class to take a input from a user
		public	static	Scanner scan = new Scanner(System.in); 
			// scanning values at run time
	public static void createPerson() {
		// creating a object addressBookModel
		AddressBookModel addressBookModel = new AddressBookModel();
		
		System.out.println("enter your first name");
		String firstName = scan.next();
		addressBookModel.setFirstName(firstName);
		uniquePerson(firstName);
		System.out.println("Enter Your Last Name");
		String lastName = scan.next();
		System.out.println("Enter Your city Name");
		String city = scan.next();
		System.out.println("Enter Your state Name");
		String state = scan.next();
		System.out.println("Enter Your phone Number");
		long phoneNumber = scan.nextLong();
		System.out.println("Enter Your zip");
		int zip = scan.nextInt();
		System.out.println("Enter Your email");
		String email = scan.next();
		// setting the user inputs in address book model
		
		addressBookModel.setLastName(lastName);
		addressBookModel.setCity(city);
		addressBookModel.setEmail(email);
		addressBookModel.setPhoneNumber(phoneNumber);
		addressBookModel.setState(state);
		addressBookModel.setZip(zip);
		
		addressBookModels.add(addressBookModel);
		}
	// Edit contact
		public void updatePerson(String name) {
			int flag = 0;
			for (AddressBookModel model : addressBookModels) {
				if (model.getFirstName().equals(name)) {
					flag = 1;
					System.out.println("Enter what to update(city/state/phone/zip):");
					String update = scan.next();
					switch (update) {
					case "city":
						System.out.println("Enter city name to update:");
						String city = scan.next();
						model.setCity(city);

						break;
					case "state":
						System.out.println("Enter state name to update:");
						String state = scan.next();
						model.setState(state);
						break;
					case "phone":
						System.out.println("Enter phone number to update:");
						int phoneNumber = scan.nextInt();
						model.setPhoneNumber(phoneNumber);
						break;
					case "zip":
						System.out.println("Enter Your zip");
						int zip = scan.nextInt();
						model.setZip(zip);
						break;
					default:
						System.out.println("Enter valid field");
						break;
					}
				}
			}
			if (flag == 0)
				System.out.println("Person Not Found");
			else
				System.out.println("Updated Successfully");

		}

		static public AddressBookModel getContact(String name) {
			for (AddressBookModel cont : addressBookModels) {
				if (cont.getFirstName().equals(name)) {
					return cont;
				} else {
					System.out.println("Invalid name");
				}

			}
			return null;
		}

		public void deletePerson(String name) // Delete Person
		{
			addressBookModels.remove(getContact(name));
		}

	// Unique Person
		static public String uniquePerson(String name) {
			for (AddressBookModel addressBookModel : addressBookModels) {
				if (addressBookModel.getFirstName().equals(name)) {
					System.out.println("Person already exist");
					createPerson();
				} 
			}
			return null;
		}

		// Print addressBook
		public void print() {
			for (AddressBookModel items : addressBookModels) {
				System.out.println(items);
			}
		}
}
