package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pool.Connection_Pool;

public class Employee_Access {
	static Scanner sc = new Scanner(System.in);
	static {
		System.out.println("----------");
		System.out.println("Welcome😊");
		System.out.println("----------");
	}
	
	public static void Login() {
		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();
		List<String> credentials = check(id);
		if(credentials != null) {
			System.out.print("Enter Email: ");
			String email = sc.next();
			System.out.print("Enter Password: ");
			String password = sc.next();
			if(email.equals(credentials.get(0)) && password.equals(credentials.get(1))  ) {
				System.out.println("Login Successful...☑️");
				EmployeeMenu.Emp_Menu(id,credentials.get(2),credentials.get(1));
			}
			else {
				System.out.println("Invalid Credentials...❌");
			}
		}
		else {
			System.out.println("Invalid ID...❌");
		}
	}
	
	
	private static List<String> check(int id) {
		List<String> user_details = new ArrayList<>();
		Connection con = Connection_Pool.createConnection();
		String sql = "SELECT email,password,name FROM employee where id = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			ResultSet res = pst.getResultSet();
			if(res.next()) {
				user_details.add(res.getString(1));
				user_details.add(res.getString(2));
				user_details.add(res.getString(3));
			}
			if(user_details != null) {
				return user_details;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Connection_Pool.receive(con);
		}
		return null;
	}
	
	
	
}
