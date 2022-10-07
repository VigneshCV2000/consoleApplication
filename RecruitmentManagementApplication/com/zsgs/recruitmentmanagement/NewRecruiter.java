package com.zsgs.recruitmentmanagement;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NewRecruiter {

	Scanner sc = new Scanner(System.in);

	static TreeMap<String, RecruiterDetails> recruiterSignUpDetails = new TreeMap<String, RecruiterDetails>();
	static TreeMap<Integer, String> companyList= new TreeMap<Integer, String>();


	String recruiterUserName;
	String password;
	String recruiterName;
	long contactNumber;
	String companyName;
	String emailID;

	public void newRecruiter() {
		Validations valid = new Validations();

		System.out.print("Enter your NAME : ");
		recruiterName = sc.next();
		while (!(valid.nameValidation(recruiterName))) {
			System.out.print("\nEnter a valid NAME : \n");
			recruiterName = sc.next();
		}
		System.out.println();

		System.out.print("Enter your USERNAME : ");
		recruiterUserName = sc.next();
		while (!(valid.userNameValidation(recruiterUserName))) {
			System.out.print("Enter a valid USERNAME : ");
			password = sc.next();
		}
		System.out.println();

		System.out.println("PASSWORD CONSTRAINTS : ");
		System.out.println("Minimum 8 characters ");
		System.out.println("Minimum contains 1 digit      ");
		System.out.println("Minimum contains 1 uppercase alphabet ");
		System.out.println("Minimum contains 1 lowercase alphabet ");
		System.out.println("Minimum contains 1 special character like (!@#$%^&*_) ");
		System.out.println("Set a PASSWORD : ");
		password = sc.next();
		while (!(valid.passwordValidation(password))) {
			System.out.print("Enter a valid PASSWORD : ");
			password = sc.next();
		}
		System.out.println();

		System.out.print("Enter your CONTACT NUMBER : ");
		contactNumber = sc.nextLong();
		while (!(valid.numberValidation(contactNumber))) {
			System.out.print("\nEnter a valid CONTACT NUMBER : \n");
			contactNumber = sc.nextLong();
		}
		System.out.println();

		System.out.print("Enter your ORGANIZATION NAME : ");
		companyName = sc.next();
		System.out.println();

		System.out.print("Enter your EMAIL-ID : ");
		emailID = sc.next();
		System.out.println();

		RecruiterDetails newRecruiter = new RecruiterDetails();
		newRecruiter.setUserName(recruiterUserName);
		newRecruiter.setRecruiterName(recruiterName);
		newRecruiter.setPassword(password);
		newRecruiter.setCompanyName(companyName);
		newRecruiter.setRecruiterEmailID(emailID);

		recruiterSignUpDetails.put(recruiterUserName, newRecruiter);
		Integer companyID = Integer.valueOf(newRecruiter.getCompanyID());
		companyList.put(companyID, newRecruiter.getCompanyName());

	}

	public void newRecruiterLogin() {
		System.out.print("Enter your USERNAME : ");
		recruiterUserName = sc.next();
		System.out.println();
		while (!recruiterSignUpDetails.containsKey(recruiterUserName)) {
			System.out.print("RECRUITER does not exist !");
			System.out.print("Enter a valid USERNAME : ");
			recruiterUserName = sc.next();
			System.out.println();

		}
		var currentRecruiter = recruiterSignUpDetails.get(recruiterUserName);
		System.out.println();
		System.out.print("Enter your PASSWORD : ");
		password = sc.next();
		System.out.println();
		while (!(password.equals(currentRecruiter.getPassword()))) {
			System.out.println("Your PASSWORD does not match ! ");
			System.out.print("Enter a valid PASSWORD : ");
			password = sc.next();
			System.out.println();

		}

		LoginPage login = new LoginPage();
		login.loginForRecruiter();

	}

	public void showCompanies() {
		if (companyList.size() == 0) {
			System.out.println("\n Currently we dont have any companies hiring !\n");
		} else {
			System.out.println(
					"+----------------------------------------------------------------+");
			System.out.printf("|        %-17s|        %-30s|\n", "COMPANY ID", "COMPANY NAME");
			System.out.println(
					"+----------------------------------------------------------------+");
			for (Map.Entry<Integer, String> entry : companyList.entrySet()) {
				int id = entry.getKey();
				String companyName = entry.getValue();
				System.out.printf("|        %-17s|        %-30s|\n", id, companyName);
			}
			System.out.println(
					"+----------------------------------------------------------------+");
			System.out.println();

		}

	}
}
