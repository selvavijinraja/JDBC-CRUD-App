package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pool.Connection_Pool;

public class Employee_CRUD {
	static Scanner sc = new Scanner(System.in);
	public static void insert_Emp() {
		Connection con = Connection_Pool.getConnection();
		String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.print("Enter the number of records to insert: ");
			int rec = sc.nextInt();
			for(int i=0;i<rec;i++) {
				System.out.print("Enter the id for " +(i+1) + "th column: ");
				pst.setInt(1, sc.nextInt());
				System.out.print("Enter the name for " +(i+1) + "th column: ");
				pst.setString(2, sc.next());
				System.out.print("Enter the email for " +(i+1) + "th column: ");
				pst.setString(3, sc.next());
				System.out.print("Enter the department for " +(i+1) + "th column: ");
				pst.setString(4, sc.next());
				System.out.print("Enter the salary for " +(i+1) + "th column: ");
				pst.setDouble(5, sc.nextDouble());
				System.out.print("Enter the password for " +(i+1) + "th column: ");
				pst.setString(6, sc.next());
				System.out.println("_______________________________________");
				pst.addBatch();
			}
			pst.executeBatch();
			
			System.out.println("Data inserted successfully...☑️");
			System.out.println("_______________________________________");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connection_Pool.receive(con);
		}
	}
	
	public static void delete_Emp() {
		Connection con = Connection_Pool.getConnection();
		String sql = "DELETE FROM employee WHERE id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.print("Enter the id to delete: ");
			pst.setInt(1, sc.nextInt());
			pst.execute();
			System.out.println("Data deleted successfully...☑️");
			System.out.println("_______________________________________");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connection_Pool.receive(con);
		}
		
	}
	
	public static void update_Emp() {
		Connection con=null;
		try {
		con = Connection_Pool.getConnection();
		System.out.print("Enter the Employee Id to update: ");
		int id=sc.nextInt();
		System.out.println("1. Name\n2. Email\n3. Department\n4. Salary\n5. Password");
		System.out.print("Enter the column to update: ");
		int choice = sc.nextInt();
		String col=null;
		switch (choice) {
		case 1:
			col = "name";
			break;
		case 2:
			col = "email";
			break;
		case 3:
			col = "department";
			break;
		case 4:
			col = "salary";
			break;
		case 5:
			col = "password";
			break;

		default:
			break;
		}
		String sql = "UPDATE employee SET "+ col +" = ? WHERE id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		
		switch (choice) {
		case 1:
			System.out.print("Enter new name to update: ");
			pst.setString(1, sc.next());
			pst.setInt(2, id);
			pst.execute();
			System.out.println(sql);
			System.out.println("Data updated successfully...☑️");
			break;
		case 2:
			System.out.print("Enter new Email to update: ");
			pst.setString(1, sc.next());
			pst.setInt(2, id);
			pst.execute();
			System.out.println("Data updated successfully...☑️");
			break;
		case 3:
			System.out.print("Enter new Department to update: ");
			pst.setString(1, sc.next());
			pst.setInt(2, id);
			pst.execute();
			System.out.println("Data updated successfully...☑️");
			break;
		case 4:
			System.out.print("Enter new Salary to update: ");
			pst.setDouble(1, sc.nextDouble());
			pst.setInt(2, id);
			pst.execute();
			System.out.println("Data updated successfully...☑️");
			break;
		case 5:
			System.out.print("Enter new password to update: ");
			pst.setString(1, sc.next());
			pst.setInt(2, id);
			pst.execute();
			System.out.println("Data updated successfully...☑️");
			break;
		default:
			System.out.println("Invalid option...❌");
			break;
		}
		
		System.out.println("_______________________________________");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connection_Pool.receive(con);
		}
		
		
		
	}
	
	public static void viewSingleEmp() {
		Connection con = Connection_Pool.getConnection();
		String sql = "SELECT * FROM employee WHERE id = ? ";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.print("Enter the id to view: ");
			pst.setInt(1, sc.nextInt());
			boolean b = pst.execute();
			System.out.println("Id\tName\tEmail\t\t\tDepartment\tSalary\t\tPassword");
			System.out.println("----------------------------------------------------------------------"
					+ "---------------------");
			if(b) {
				ResultSet res = pst.getResultSet();
				if(res.next()) {
					System.out.println(res.getInt(1) + "\t"+res.getString(2) +"\t"+ res.getString(3) +"\t\t"+ res.getString(4)
					+"\t\t"+ res.getDouble(5) +"\t\t"+ res.getString(6));
					
				}
				
			}
			System.out.println("----------------------------------------------------------------------"
					+ "---------------------");
			Connection_Pool.receive(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connection_Pool.receive(con);
		}
	}
	
	public static void viewSingleEmp(int id) {
		Connection con = Connection_Pool.getConnection();
		String sql = "SELECT * FROM employee WHERE id = ? ";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			boolean b = pst.execute();
			System.out.println("----------------------------------");
			if(b) {
				ResultSet res = pst.getResultSet();
				if(res.next()) {
					System.out.println("Id:\t\t"+res.getInt(1));
					System.out.println("Name:\t\t"+res.getString(2));
					System.out.println("Emain:\t\t"+res.getString(3));
					System.out.println("Department:\t"+res.getString(4));
					System.out.println("Salary:\t\t"+res.getDouble(5));
					System.out.println("Password:\t"+res.getString(6));
				}
				
			}
			System.out.println("----------------------------------");
			Connection_Pool.receive(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connection_Pool.receive(con);
		}
	}
	
	public static void updatePassword(int id,String password) {
		Connection con = Connection_Pool.getConnection();
		System.out.print("Enter old password: ");
		String old_pwd = sc.next();
		String sql = "UPDATE employee SET password = ? WHERE id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			if(password.equals(old_pwd)) {
				System.out.print("Enter new password: ");
				String new_pwd = sc.next();
				System.out.print("Confirm new password: ");
				if(new_pwd.equals(sc.next())) {
					pst.setString(1, new_pwd);
					pst.setInt(2, id);
					pst.execute();
					System.out.println("Password updated successfully...");
				}
				else {
					System.out.println("Password does not match...");
				}
			}
			else {
				System.out.println("Please enter correct password...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Connection_Pool.receive(con);
		}
		
		
	}
	
	public static void viewAllEmp() {
		Connection con = Connection_Pool.getConnection();
		String sql = "SELECT * FROM employee";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet res = st.executeQuery(sql);
			System.out.println("Id\tName\tEmail\t\t\tDepartment\tSalary\t\tPassword");
			System.out.println("----------------------------------------------------------------------"
					+ "---------------------");
			while(res.next()) {
				System.out.println(res.getInt(1) + "\t"+res.getString(2) +"\t"+ res.getString(3) +"\t\t"+ res.getString(4)
				+"\t\t"+ res.getDouble(5) +"\t\t"+ res.getString(6));
			}
			System.out.println("----------------------------------------------------------------------"
					+ "---------------------");
			Connection_Pool.receive(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connection_Pool.receive(con);
		}
		
	}
}
