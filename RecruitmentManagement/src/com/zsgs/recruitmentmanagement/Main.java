package com.zsgs.recruitmentmanagement;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Validations validation = new Validations();
		LoginPage loginPage = new LoginPage();
		UserPage userPage = new UserPage();
		NewRecruiter newRecruiter = new NewRecruiter();
		WHILE: while (true) {

			try {

				System.out.println("+---------------------------------------------------+");
				System.out.println("|   WELCOME TO RECRUITMENT MANAGEMENT APPLICATION   |");
				System.out.println("+---------------------------------------------------+");
				System.out.printf("|%51s|%n", "");
				System.out.printf(
						"|                 %-34s|%n|                 %-34s|%n|                 %-34s|%n|                 %-34s|%n|                 %-34s|%n",
						"1. NEW RECRUITER", "2. RECRUITER LOGIN", "3. NEW USER", "4. USER LOGIN", "5. EXIT");
				System.out.printf("|%51s|%n", "");
				System.out.println("+---------------------------------------------------+");
				System.out.println();
				int choice;
				System.out.print("Enter your choice : ");
				choice = new Scanner(System.in).nextInt();
				if (choice < 1 || choice > 5)
					throw new Exception();

				System.out.println();

				switch (choice) {
				case 1:
					newRecruiter.newRecruiter();
					break;
				case 2:
					newRecruiter.newRecruiterLogin();
					break;
				case 3:
					userPage.newUser();
					break;
				case 4:
					userPage.userLogin();
					break;
				case 5:
					break WHILE;
				}
			} catch (Exception e) {
				System.out.println("\nYou entered an invalid option\n");
			}

		}
	}
}
