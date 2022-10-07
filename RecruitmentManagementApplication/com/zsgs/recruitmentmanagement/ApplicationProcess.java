package com.zsgs.recruitmentmanagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class ApplicationProcess {

	Scanner sc = new Scanner(System.in);

	private String name;
	private int age;
	private String userDateOfBirth;
	private int experience;
	private String email;
	private long contactNumber;
	private String address;
	private int jobID;
	RecruitmentFunctionalaties recruitFunctions = new RecruitmentFunctionalaties();
	ApplicantDetails applicantDetails = new ApplicantDetails();

	String[] jobDesignation = { "No Designation", "Software Developer", "QA Engineer", "Web Developer",
			"Sales Executive", "Content Writer", "Designer-UI/UX", "Technical Support Engineer", "Product Marketer" };

	static ArrayList<ApplicantDetails> applicantsInfo = new ArrayList<ApplicantDetails>();

	public void veiwOpenings() {
		recruitFunctions.showJobsDetails();
	}

	public boolean jobAvailabilityCheck() {
		return recruitFunctions.checkJobAvailability();
	}

	public void applyForJob(String userName, TreeMap<String, UserDetails> userSignUpDetails) {
		if (userSignUpDetails.containsKey(userName)) {
			Validations valid = new Validations();
			var userInfo = userSignUpDetails.get(userName);
			name = userInfo.getName();
			System.out.print("Enter your age :");
			age = sc.nextInt();
			System.out.println();
			System.out.print("Enter your date of birth (DD/MM/YYYY) :");
			userDateOfBirth = sc.next();
			System.out.println();
			System.out.print("Enter your experience :");
			experience = sc.nextInt();
			System.out.println();
			System.out.print("Enter your email ID :");
			email = sc.next();
			while (!valid.emailValidation(email)) {
				System.out.println("Your email ID is invalid ");
				System.out.print("Enter a valid email ID\n");
				email = new Scanner(System.in).next();
			}
			System.out.println();
			System.out.print("Enter your contact number :");
			contactNumber = sc.nextLong();
			while (!(valid.numberValidation(contactNumber))) {
				System.out.println("Enter a valid mobile number : ");
				contactNumber = sc.nextLong();
				System.out.println();
			}
			System.out.println();
			System.out.println("Enter your address :");
			address = sc.next();
			System.out.println();
			System.out.print("Enter the jobId you want to apply for :");
			jobID = sc.nextInt();
			System.out.println();
			applicantDetails = new ApplicantDetails(userName, name, age, userDateOfBirth, experience, email,
					contactNumber, address, jobID);
			applicantsInfo.add(applicantDetails);
			System.out.print("Application for " + jobDesignation[jobID] + " is added sucessfully !\n");
			System.out.println();

		} else {
			System.out.println("Key not found");
		}

	}

	public void showApplicants() {
		if (applicantsInfo.size() == 0) {
			System.out.println("There are no applicants");
		} else {
			System.out.println(
					"+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.printf(
					"|  %-6s|     %-30s|     %-5s|     %-15s|    %-15s|     %-30s|     %-20s|     %-10s|     %-10s|     %-20s|\n",
					"S.NO", "NAME OF THE APPLICANT", "AGE", "DATE OF BIRTH", "EXPERIENCE", "EMAIL-ID", "CONTACT NUMBER",
					"ADDRESS", "JOB ID", "JOB DESIGNATION");
			System.out.println(
					"+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

			for (int ind = 0; ind < applicantsInfo.size(); ind++) {
				var applicantInformation = applicantsInfo.get(ind);

				System.out.printf(
						"|  %-6s|     %-30s|     %-5s|     %-15s|    %-15s|     %-30s|     %-20s|     %-10s|     %-10s|     %-20s|\n",
						ind + 1, applicantInformation.getName(), applicantInformation.getAge(),
						applicantInformation.getDateOfBirth(), applicantInformation.getExperience(),
						applicantInformation.getEmail(), applicantInformation.getContactNumber(),
						applicantInformation.getAddress(), applicantInformation.getJobID(),
						jobDesignation[applicantInformation.getJobID()]);
				System.out.println(
						"+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

//				
//				
//				System.out.println("Name : " + applicantInformation.getName());
//				System.out.println("Age : " + applicantInformation.getAge());
//				System.out.println("Date of birth (DD/MM/YYYY) : " + applicantInformation.getDateOfBirth());
//				System.out.println("Experience : " + applicantInformation.getExperience());
//				System.out.println("Email ID : " + applicantInformation.getEmail());
//				System.out.println("Contact number : " + applicantInformation.getContactNumber());
//				System.out.println("Address : " + applicantInformation.getAddress());
//				System.out.println("jobId applied for : " + applicantInformation.getJobID());
//				System.out.println("job Designation applied for : " + jobDesignation[applicantInformation.getJobID()]);
//				System.out.println();
				

			}

		}
	}

}
