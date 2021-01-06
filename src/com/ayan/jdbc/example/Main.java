package com.ayan.jdbc.example;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("-------- Welcome to my app : Ayan -----------\n");
		
		startApp(sc);
	}

	private static void startApp(Scanner sc) {
		
		System.out.println("Press: 1: View all records");
		System.out.println("Press: 2: Create a new record");
		System.out.println("Press: 3: Update a existing record");
		System.out.println("Press: 4: Delete a record");
		System.out.println("Press: 5: Close this App \n");
		
		BussLayer buss = new BussLayer();
		System.out.print("choose a operation number: ");
		int no = sc.nextInt();

		switch (no) {
		case 1:
			// View all records
			buss.selectData();
			break;
		case 2:
			// Create a new record
			System.out.println("Enter Id: ");
			int id = sc.nextInt();
			System.out.println("Enter Name: ");
			String name = sc.next();
			System.out.println("Enter Rollno: ");
			String rollno = sc.next();
			System.out.println("Enter Marks: ");
			String marks = sc.next();

			buss.insertData(id, name, rollno, marks);
			break;
		case 3:
			// Update a existing record
			System.out.println("What you want to update -> 1: id | 2: name | 3: rollno | 4: marks");
			int n = sc.nextInt();
			System.out.println("Enter Id: ");
			int sid = sc.nextInt();
			System.out.println("Enter Value: ");
			String val = sc.next();

			buss.updateData(sid, n, val);
			break;
		case 4:
			// Delete a record
			System.out.println("Enter Id: ");
			int idd = sc.nextInt();

			buss.deleteData(idd);
			break;

		default:
			// Close
			System.out.println("App Closed");
			return;
		}
		startApp(sc);
	}

}
