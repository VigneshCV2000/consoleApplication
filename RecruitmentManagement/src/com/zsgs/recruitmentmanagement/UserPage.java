package com.zsgs.recruitmentmanagement;

import java.util.Scanner;
import java.util.TreeMap;

import org.json.JSONObject;

public class UserPage {
	Scanner sc = new Scanner(System.in);
	ApplicationProcess applicationProcess = new ApplicationProcess();

	public static JSONObject userSignUpDetails = new JSONObject();
	String userName;
	String password;
	String name;

	public void newUser() {
		Validations valid = new Validations();
		System.out.print("Enter your USERNAME : ");
		userName = sc.next();
		while (!(valid.userNameValidation(userName))) {
			System.out.print("Enter a valid USERNAME : ");
			password = sc.next();
		}
		System.out.println();
		System.out.println("PASSWORD costraints : ");
		System.out.println("Minimum 8 characters ");
		System.out.println("Minimum contains 1 digit      ");
		System.out.println("Minimum contains 1 uppercase alphabet ");
		System.out.println("Minimum contains 1 lowercase alphabet ");
		System.out.println("Minimum contains 1 special character like (!@#$%^&*_) ");
		System.out.print("Set a PASSWORD : ");
		password = sc.next();
		while (!(valid.passwordValidation(password))) {
			System.out.print("Enter a valid PASSWORD : ");
			password = sc.next();
			System.out.println();
		}
		System.out.println();
		System.out.print("Enter your NAME : ");
		name = sc.next();
		while (!(valid.nameValidation(name))) {
			System.out.print("\nEnter a valid NAME : \n");
			name = sc.next();
			System.out.println();
		}
		System.out.println();
		JSONObject userInfo = new JSONObject();
		userInfo.put(UserDetails.NAME, name);
		userInfo.put(UserDetails.PASSWORD, password);
		userInfo.put(UserDetails.USERNAME, userName);
		userInfo.put(UserDetails.USERID, new UserDetails().userId);

		userSignUpDetails.put(userName, userInfo);
	}

	public void userLogin() {
		System.out.print("Enter your USERNAME : ");
		userName = sc.next();
		System.out.println();

		while (!userSignUpDetails.has(userName)) {
			System.out.print("USER does not exist !");
			System.out.print("Enter a valid USERNAME : ");
			userName = sc.next();
			System.out.println();

		}
		JSONObject currentUserDetails = userSignUpDetails.getJSONObject(userName);
		System.out.print("Enter your PASSWORD : ");
		password = sc.next();
		System.out.println();

		while (!(password.equals(currentUserDetails.get((RecruiterDetails.PASSWORD))))) {
			System.out.println("Your PASSWORD does not match ! ");
			System.out.print("Enter a valid PASSWORD : ");
			password = sc.next();
			System.out.println();

		}
		WHILE: while (true) {
			try {
				System.out.println("+----------------------------------------------------------------+");
				System.out.printf("|                 %-47s|%n",
						"Welcome " + currentUserDetails.getString(UserDetails.NAME));
				System.out.println("+----------------------------------------------------------------+");
				System.out.printf("|%64s|%n", "");
				System.out.printf(
						"|                 %-47s|%n|                 %-47s|%n|                 %-47s|%n|                 %-47s|%n|                 %-47s|%n",
						"1. VIEW HIRING COMPANIES ", "2. VIEW OPENINGS", "3. APPLY FOR JOB","4. VIEW MY APPLICATION", "5. LOGOUT");
				System.out.printf("|%64s|%n", "");
				System.out.println("+----------------------------------------------------------------+");
				System.out.println();
				System.out.print("Enter your option : ");
				int option = new Scanner(System.in).nextInt();
				System.out.println();
				if (option < 1 || option > 5)
					throw new Exception();
				switch (option) {
				case 1:
					NewRecruiter company = new NewRecruiter();
					company.showCompanies();
					break;
				case 2:
					applicationProcess.veiwOpenings();
					break;
				case 3:
					applicationProcess.applyForJob(userName, userSignUpDetails);
					break;
				case 4:
					applicationProcess.viewYourApplication(userName);
					break;
				case 5:
					break WHILE;
				}

			} catch (Exception e) {
				System.out.print("\nYou entered an invalid option\n");
			}
		}

	}

}
