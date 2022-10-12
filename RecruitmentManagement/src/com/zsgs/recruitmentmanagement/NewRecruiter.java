package com.zsgs.recruitmentmanagement;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class NewRecruiter {

	Scanner sc = new Scanner(System.in);

	public static JSONObject recruiterSignUpDetails = new JSONObject();
	public static JSONObject companyList = new JSONObject();
	public static JSONArray jobList = new JSONArray();
	public static JSONObject companyNameAndID = new JSONObject();
	String recruiterUserName;
	String password;
	String recruiterName;
	long contactNumber;
	String companyName;
	String emailID;
	static int temp = 20221;
	static Integer companyID;

	public void newRecruiter() {
		Validations valid = new Validations();

		System.out.print("Enter your NAME : ");
		recruiterName = sc.next();
		while (!(valid.nameValidation(recruiterName))) {
			System.err.print("\nEnter a valid NAME : \n");
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
		System.out.print("Set a PASSWORD : ");
		password = sc.next();
		while (!(valid.passwordValidation(password))) {
			System.err.print("Enter a valid PASSWORD : ");
			password = sc.next();
		}
		System.out.println();

		System.out.print("Enter your CONTACT NUMBER : ");
		contactNumber = sc.nextLong();
		while (!(valid.numberValidation(contactNumber))) {
			System.err.print("\nEnter a valid CONTACT NUMBER : \n");
			contactNumber = sc.nextLong();
		}
		System.out.println();

		System.out.print("Enter your ORGANIZATION NAME : ");
		companyName = sc.next();
		companyID = temp++;
		String stringCompanyID = companyID.toString();
		companyNameAndID.put(stringCompanyID, companyName);
//		System.out.println("Companyname and id" + " " + companyNameAndID);

		JSONArray jobList = new JSONArray();
		JSONArray applicants = new JSONArray();
		companyList.put(companyName, jobList);
		ApplicationProcess.submittedApplications.put(companyName, applicants);
		System.out.println();

		System.out.print("Enter your EMAIL-ID : ");
		emailID = sc.next();
		System.out.println();

		JSONObject recruiterInfo = new JSONObject();
		recruiterInfo.put(RecruiterDetails.RECRUITERNAME, recruiterName);
		recruiterInfo.put(RecruiterDetails.PASSWORD, password);
		recruiterInfo.put(RecruiterDetails.RECRUITERCONTACTNUMBER, contactNumber);
		recruiterInfo.put(RecruiterDetails.RECRUITEREMAILID, emailID);
		recruiterInfo.put(RecruiterDetails.RECRUITERCOMPANYNAME, companyName);
		recruiterInfo.put(RecruiterDetails.RECRUITERCOMPANYID, companyID);
		recruiterSignUpDetails.put(recruiterUserName, recruiterInfo);
	}

	public void newRecruiterLogin() {
		System.out.print("Enter your USERNAME : ");
		recruiterUserName = sc.next();
		System.out.println();
		while (!recruiterSignUpDetails.has(recruiterUserName)) {
			System.err.print("RECRUITER does not exist !");
			System.err.print("Enter a valid USERNAME : ");
			recruiterUserName = sc.next();
			System.out.println();

		}
		JSONObject currentRecruiterDetails = recruiterSignUpDetails.getJSONObject(recruiterUserName);
		System.out.print("Enter your PASSWORD : ");
		password = sc.next();
		System.out.println();

		while (!(password.equals(currentRecruiterDetails.get((RecruiterDetails.PASSWORD))))) {
			System.err.println("Your PASSWORD does not match ! ");
			System.err.print("Enter a valid PASSWORD : ");
			password = sc.next();
			System.out.println();

		}

		LoginPage login = new LoginPage();
		login.loginForRecruiter(currentRecruiterDetails);

	}

	public void showCompanies() {
		if (companyList.length() == 0) {
			System.err.println("\n Currently we dont have any companies hiring !\n");
		} else {
			System.out.println("+----------------------------------------------------------------+");
			System.out.printf("|        %-17s|        %-30s|\n", "COMPANY ID", "COMPANY NAME");
			System.out.println("+----------------------------------------------------------------+");
			for (String idOfTheCompany : companyNameAndID.keySet()) {
				Object nameOfTheCompany = companyNameAndID.get(idOfTheCompany);
				System.out.printf("|        %-17s|        %-30s|\n", idOfTheCompany, nameOfTheCompany);
			}
		}
		System.out.println("+----------------------------------------------------------------+");
		System.out.println();

	}

}
