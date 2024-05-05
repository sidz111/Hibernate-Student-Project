package com.siddhu.hibernate.presentation;

import java.util.Scanner;

public class MainApp {
	static {
		System.out.println("=============WELCOME=============");
	}

	public static void main(String[] args) {
		App app = new AppImpl();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete By Roll");
			System.out.println("4. Find Student by Roll");
			System.out.println("5. Show All Students");
			System.out.println("6. Exit");
			System.out.println("Enter Option:");
			Integer choice = sc.nextInt();
			switch (choice) {
			case 1:
				app.addStudent();
				break;

			case 2:
				app.updateStudent();
				break;
			case 3:
				app.deleteStudent();
				break;
			case 4:
				app.findById();
				break;
			case 5:
				app.showAllStudents();
				break;
			case 6:
				System.out.println("Ok As you Wish!!!!");
				System.exit(0);
			default:
				System.out.println("Enter Valid option");
			}
		}

	}
}
