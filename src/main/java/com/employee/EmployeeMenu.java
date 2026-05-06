package com.employee;

import java.util.Scanner;

public class EmployeeMenu {
	static Scanner sc = new Scanner(System.in);
	public static void Emp_Menu(int id,String name,String password) {
		int choice =0;
		do {
			System.out.println("----------------------");
			System.out.println("Welcome "+name + " 😁");
			System.out.println("----------------------");
			System.out.println("1. View Profile\n2. Change Password\n3. Logout");	
			System.out.print("Select option: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Employee_CRUD.viewSingleEmp(id);
				break;
			case 2:
				Employee_CRUD.updatePassword(id,password);
				break;
			case 3:
				System.out.println("----------------------");
				break;

			default:
				System.out.println("Invalid Option...❌");
				break;
			}
		} while (choice!=3);
		
	}
	
}
