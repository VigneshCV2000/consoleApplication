package com.zsgs.recruitmentmanagement;

import java.util.Scanner;
import java.util.TreeMap;

public class UserPage {
	Scanner sc = new Scanner(System.in);
	ApplicationProcess applicationProcess = new ApplicationProcess();

	static TreeMap<String, UserDetails> userSignUpDetails;

	UserPage() {
		userSignUpDetails = new TreeMap<String, UserDetails>();
	}

	String userName;
	String password;
	String name;

	public void newUser() {
		Validations valid=new Validations();
		System.out.print("Enter your USERNAME : ");
		userName = sc.next();
		while(!(valid.userNameValidation(userName))) {
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
		while(!(valid.passwordValidation(password))) {
			System.out.print("Enter a valid PASSWORD : ");
			password = sc.next();
			System.out.println();
		}
		System.out.println();
		System.out.print("Enter your NAME : ");
		name = sc.next();
		while(!(valid.nameValidation(name))) {
			System.out.print("\nEnter a valid NAME : \n");
			name = sc.next();
			System.out.println();
		}
		System.out.println();
		UserDetails userInfo = new UserDetails(userName, password, name);
		userSignUpDetails.put(userName, userInfo);

	}

	public void userLogin() {
		System.out.print("Enter your USERNAME : ");
		userName = sc.next();
		System.out.println();
		while (!userSignUpDetails.containsKey(userName)) {
			System.out.print("USER does not exist !");
			System.out.println("Enter a valid USERNAME : ");
			userName = sc.next();
			System.out.println();
		}
		var currentUser = userSignUpDetails.get(userName);
		System.out.println();
		System.out.print("Enter your PASSWORD : ");
		password = sc.next();
		System.out.println();
		while(!(password.equals(currentUser.getPassword()))) {
			System.out.println("Your PASSWORD does not match ! ");
			System.out.println("Enter a valid PASSWORD : ");
			password = sc.next();
			System.out.println();
		}

		WHILE:
		while (true) {
			try {
				System.out.println("+----------------------------------------------------------------+");
				System.out.printf("|                 %-47s|%n","Welcome "+currentUser.getName());
				System.out.println("+----------------------------------------------------------------+");
				System.out.printf("|%64s|%n", "");
				System.out.printf("|                 %-47s|%n|                 %-47s|%n|                 %-47s|%n|                 %-47s|%n",
						"1. VIEW HIRING COMPANIES ","2. VIEW OPENINGS", "3. APPLY FOR JOB", "4. LOGOUT");
				System.out.printf("|%64s|%n", "");
				System.out.println("+----------------------------------------------------------------+");
				System.out.print("Enter your choice : ");
				int option = new Scanner(System.in).nextInt();
				System.out.println();
				if(option<1||option>4)throw new Exception();
					switch (option) {
					case 1:
						NewRecruiter company=new NewRecruiter();
						company.showCompanies();
						break;
					case 2:
						applicationProcess.veiwOpenings();
						break;
					case 3:
						if(applicationProcess.jobAvailabilityCheck()) {
							applicationProcess.applyForJob(userName, userSignUpDetails);
							break;
						}
						else {
							System.out.println("Currently we dont have any openings ! Check us later");
							break;
						}
						
					case 4:
						break WHILE;
					}
				

			}catch(Exception e) {
				System.out.print("\nYou entered an invalid option\n");
			}
		}


	}

}
