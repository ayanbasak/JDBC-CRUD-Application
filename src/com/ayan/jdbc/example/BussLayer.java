package com.ayan.jdbc.example;

public class BussLayer {

	private DBManager db;

	public BussLayer() {
		db = new DBManager();
	}

	public void selectData() {
		db.selectRecords();
	}

	public void insertData(int sid, String name, String rollno, String marks) {
		String cmd = "insert into tbl_student(sid,sname,rollno,marks) values('" + sid + "','" + name + "','" + rollno
				+ "','" + marks + "')";
		if (db.RecordsManipulation(cmd)) {
			System.out.println("Record has been saved successfully");
		} else {
			System.out.println("Record has not been saved successfully");
		}
	}

	public void updateData(int sid, int n, String val) {
		String cmd = null;
		// 1: id | 2: name | 3: rollno | 4: marks
		switch (n) {
		case 1:
			cmd = "update tbl_student set sid='" + val + "'where sid='" + sid + "'";
			break;
		case 2:
			cmd = "update tbl_student set sname='" + val + "'where sid='" + sid + "'";
			break;
		case 3:
			cmd = "update tbl_student set rollno='" + val + "'where sid='" + sid + "'";
			break;
		case 4:
			cmd = "update tbl_student set marks='" + val + "'where sid='" + sid + "'";
			break;
		default:
			return;
		}

		if (db.RecordsManipulation(cmd)) {
			System.out.println("Record has been updated successfully");
		} else {
			System.out.println("Record has not been updated successfully");
		}
	}

	public void deleteData(int sid) {
		String cmd = "delete from tbl_student where sid='" + sid + "'";
		if (db.RecordsManipulation(cmd)) {
			System.out.println("Record has been deleted successfully");
		} else {
			System.out.println("Record has not been deleted successfully");
		}
	}
}
