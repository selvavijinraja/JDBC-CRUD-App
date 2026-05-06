package com.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pool.Connection_Pool;

public class Admin_access {
	static Scanner sc = new Scanner(System.in);
	static String username;
	static String password;
	public static void createConnection() {
		Connection con = Connection_Pool.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("SELECT * from admin WHERE id=1");
			if(res.next()) {
				username = res.getString(2);
				password = res.getString(3); 
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Connection_Pool.receive(con);
		}
	}
	
	public static boolean Login() {
		createConnection();
		System.out.println("----------------------");
		System.out.println("Enter the credentials");
		System.out.println("----------------------");
		System.out.print("Username: ");
		String uname = sc.next();
		System.out.print("Password: ");
		String pwd = sc.next();
		if(username.equals(uname) && password.equals(pwd)) {
			System.out.println("Login Successfull...☑️");
			System.out.println("-----------------------------");
			return true;
		}
		else {
			System.out.println("Invalid Credentials...❌");
			System.out.println("----------------------");
		}
		return false;
		
		
	}
	
	
	
	
}
