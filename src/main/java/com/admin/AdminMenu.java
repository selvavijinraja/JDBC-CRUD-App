package com.admin;
import com.employee.*;
import java.util.Scanner;

import com.mainMenu.MainMenu;

public class AdminMenu {
	static Scanner sc = new Scanner(System.in);
	static {
		System.out.println("Welcome to Employee Dashboard");
		System.out.println("-----------------------------");
	}
	public static void Admin_menu() {
		int choice=0;
		do {
			System.out.println("1. Insert Employee\n2. Delete Employee\n3. Update Employee\n4. View based on id\n5. View all\n6. Back");
			System.out.print("Select operation to perform: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Employee_CRUD.insert_Emp();
				break;
			case 2:
				Employee_CRUD.delete_Emp();;
				break;
			case 3:
				Employee_CRUD.update_Emp();
				break;
			case 4:
				Employee_CRUD.viewSingleEmp();
				break;
			case 5:
				Employee_CRUD.viewAllEmp();
				break;
			case 6:
				System.out.println("-----------------------------");
				MainMenu.main(null);
				break;
			default:
				System.out.println("Invalid option...❌");
				break;
			}
		} while (choice!=6);
		
	}
}
