package com.mainMenu;

import java.util.Scanner;
import com.admin.*;

import com.admin.Admin_access;
import com.employee.Employee_Access;

public class MainMenu {
	static {
		System.out.println("---------------------");
		System.out.println("Welcome to the Portal");
		System.out.println("---------------------");
	}
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int choice=0;
		do {
			System.out.print("1. Admin\n2. Employee\n3. Exit\nSelect user: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				if(Admin_access.Login()) {
					AdminMenu.Admin_menu();
				}
				break;
			case 2:
				
				Employee_Access.Login();
				break;
			case 3:
				System.out.println("---------------");
				System.out.println("Thank you...😊");
				System.out.println("---------------");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option...❌");
				break;
			}
		} while (choice != 3);
		
		
	}

}
