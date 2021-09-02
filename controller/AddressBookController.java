package com.bl.controller;

//import java.util.ArrayList;
import java.util.Scanner;

import com.bl.service.AddressBookService;

public class AddressBookController {
	public static void main(String[] args) {
		// ArrayList<AddressBookService> addressBook = new
		// ArrayList<AddressBookService>();

		AddressBookService addressBookService = new AddressBookService();
		try (Scanner scan = new Scanner(System.in)) {
			int choice = 0;
			final int EXIT_VALUE = 4;
			while (choice != EXIT_VALUE) {
				System.out.println("1.Add Person\n2.Update Person\n3.Delete Person\n" + EXIT_VALUE + ".Exit");
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					AddressBookService.createPerson();
					addressBookService.print();
					break;
				case 2:
					System.out.println("Enter name of person to Update");
					String name = scan.next();
					addressBookService.updatePerson(name);
					addressBookService.print();
					break;
				case 3:
					System.out.println("Enter name of person to Delete");
					String n = scan.next();
					addressBookService.deletePerson(n);
					addressBookService.print();
					break;
				case EXIT_VALUE:
					System.out.println("Exit");
					break;
				default:
					System.out.println("Enter valid value");
					break;
				}
			}
		}
	}
}
