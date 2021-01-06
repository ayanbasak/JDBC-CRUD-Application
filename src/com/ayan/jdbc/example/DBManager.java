package com.ayan.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbtest";
	private String uid = "root";
	private String passwd = "ayan@9851571961";

	public void selectRecords() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uid, passwd);
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from tbl_student");
			System.out.print("|===============================================================================|\n|");
			spaceSeprator("SID");
			spaceSeprator("Student Name");
			spaceSeprator("Student RollNo");
			spaceSeprator("Student Marks");
			System.out.println("\n|===================|===================|===================|===================|");
								  
			while (result.next()) {
				System.out.print("|");
				spaceSeprator(String.valueOf(result.getInt(1)));
				spaceSeprator(result.getString(2));
				spaceSeprator(result.getString(3));
				spaceSeprator(result.getString(4));
				System.out.println();
			}
			System.out.println("|===============================================================================|");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean RecordsManipulation(String query) {
		boolean flag = false;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uid, passwd);
			Statement stmt = con.createStatement();
			flag = stmt.executeUpdate(query) > 0 ? true : false;
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	public void spaceSeprator(String val) {
		int n1 = (20 - val.length());
		System.out.print("  " + val);
		for (int i = 0; i < n1 - 3; i++) {
			System.out.print(" ");
		}
		System.out.print("|");
	}

}
