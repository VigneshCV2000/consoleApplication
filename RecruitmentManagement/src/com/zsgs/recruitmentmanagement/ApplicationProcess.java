package com.zsgs.recruitmentmanagement;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

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
	public static JSONArray applicantsInfo = new JSONArray();
	public static JSONObject submittedApplications = new JSONObject();

	public void veiwOpenings() {
		NewRecruiter company = new NewRecruiter();
		company.showCompanies();
		System.out.print("Enter the name of the company you want to check openings for :");
		String companyName = sc.next();
		recruitFunctions.showJobsDetails(companyName);
	}

	public void applyForJob(String userName, JSONObject userSignUpDetails) {
		Validations valid = new Validations();
		JSONObject userInfo = userSignUpDetails.getJSONObject(userName);
		veiwOpenings();
		System.out.print("Enter the company name for which you want to apply for:");
		String companyName = sc.next();
		companyName = companyName.toUpperCase();
		System.out.println();
		name = userInfo.getString(UserDetails.NAME);
		System.out.println("+----------------------------------------------------------------+");
		System.out.printf("|                 %-47s|%n", "JOB APPLICATION");
		System.out.println("+----------------------------------------------------------------+");
		System.out.println();
		System.out.print("ENTER YOUR AGE :");
		age = sc.nextInt();
		System.out.println();
		System.out.print("ENTER YOUR DATE OF BIRTH (DD/MM/YYYY) :");
		userDateOfBirth = sc.next();
		System.out.println();
		System.out.print("ENTER YOUR EXPERIENCE :");
		experience = sc.nextInt();
		System.out.println();
		System.out.print("ENTER YOUR EMAIL-ID :");
		email = sc.next();
		System.out.println();
		while (!valid.emailValidation(email)) {
			System.out.println("YOUR EMAIL-ID IS INVALID");
			System.out.print("ENTER A VALID EMAIL-ID :\n");
			email = new Scanner(System.in).next();
		}
		System.out.print("ENTER YOUR CONTACT NUMBER :");
		contactNumber = sc.nextLong();
		System.out.println();
		while (!(valid.numberValidation(contactNumber))) {
			System.out.print("ENTER A VALID NUMBER :");
			contactNumber = sc.nextLong();
			System.out.println();
		}
		System.out.print("ENTER YOUR ADDRESS :");
		address = sc.next();
		System.out.println();
		System.out.print("ENTER THE JOB ID YOU WANT TO APPLY FOR :");
		jobID = sc.nextInt();
		System.out.println();
		System.out.println("+----------------------------------------------------------------+");
		boolean flag = false;
		JSONArray companyOpenings = NewRecruiter.companyList.getJSONArray(companyName);
		for (int i = 0; i < companyOpenings.length(); i++) {
			JSONObject opening = (JSONObject) companyOpenings.get(i);
			int requiredExperience = opening.getInt(JobDetails.EXPERIENCE);
			if (experience >= requiredExperience) {

				flag = true;
				break;
			}
		}

		boolean applicationBasicValidation = recruitFunctions.checkEligiliblityCriteria(experience, jobID, companyName);
		if (applicationBasicValidation == true) {
			JSONObject applicantDetails = new JSONObject();
			applicantDetails.put(ApplicantDetails.USERNAME, userName);
			applicantDetails.put(ApplicantDetails.NAME, name);
			applicantDetails.put(ApplicantDetails.AGE, age);
			applicantDetails.put(ApplicantDetails.DATEOFBIRTH, userDateOfBirth);
			applicantDetails.put(ApplicantDetails.EXPERIENCE, experience);
			applicantDetails.put(ApplicantDetails.EMAIL, email);
			applicantDetails.put(ApplicantDetails.CONTACTNUMBER, contactNumber);
			applicantDetails.put(ApplicantDetails.ADDDRESS, address);
			applicantDetails.put(ApplicantDetails.JOBID, jobID);
			applicantDetails.put(ApplicantDetails.APPLICATIONSTATUS, "PENDING");
			JSONArray applicantsList = submittedApplications.getJSONArray(companyName);
			applicantsList.put(applicantDetails);
			submittedApplications.put(companyName, applicantsList);
			System.out.println();
			System.out.print("Application for " + jobDesignation[jobID] + " is added sucessfully !\n");
			System.out.println();
		} else {
			System.out.print(
					"Sorry this application can't be processed since it does not pass our eligiliblity criteria.");
			System.out.println();
		}

	}

	public void showApplicants(String recruiterCompanyName) {
		JSONArray currentListOfApplicants = submittedApplications.getJSONArray(recruiterCompanyName);
		if (currentListOfApplicants.length() == 0) {
			System.err.println("There are no applicants");
		} else {
			System.out.println(
					"+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.printf(
					"|  %-6s|     %-30s|     %-5s|     %-15s|    %-15s|     %-30s|     %-20s|     %-10s|     %-10s|     %-20s|     %-20s|\n",
					"S.NO", "NAME OF THE APPLICANT", "AGE", "DATE OF BIRTH", "EXPERIENCE", "EMAIL-ID", "CONTACT NUMBER",
					"ADDRESS", "JOB ID", "JOB DESIGNATION", "APPLICATION STATUS");
			System.out.println(
					"+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			for (int ind = 0; ind < currentListOfApplicants.length(); ind++) {
				JSONObject currentApplicant = (JSONObject) currentListOfApplicants.get(ind);
				String currentApplicantName = currentApplicant.getString(ApplicantDetails.NAME);
				int currentAgeOfTheApplicant = currentApplicant.getInt(ApplicantDetails.AGE);
				String currentDOBOfApplicant = currentApplicant.getString(ApplicantDetails.DATEOFBIRTH);
				int currentApplicantExperience = currentApplicant.getInt(ApplicantDetails.EXPERIENCE);
				String currentApplicantEmail = currentApplicant.getString(ApplicantDetails.EMAIL);
				long currentApplicantContactNumber = currentApplicant.getLong(ApplicantDetails.CONTACTNUMBER);
				String currentApplicationAddress = currentApplicant.getString(ApplicantDetails.ADDDRESS);
				int currentjobID = currentApplicant.getInt(ApplicantDetails.JOBID);
				String currentApplicationStatus = currentApplicant.getString(ApplicantDetails.APPLICATIONSTATUS);
				System.out.printf(
						"|  %-6s|     %-30s|     %-5s|     %-15s|    %-15s|     %-30s|     %-20s|     %-10s|     %-10s|     %-20s|     %-20s|\n",
						ind + 1, currentApplicantName, currentAgeOfTheApplicant, currentDOBOfApplicant,
						currentApplicantExperience, currentApplicantEmail, currentApplicantContactNumber,
						currentApplicationAddress, currentjobID, jobDesignation[currentjobID],
						currentApplicationStatus);
			}
			System.out.println(
					"+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println();

		}

	}

	public void reviewApplication(String recruiterCompanyName) {
		showApplicants(recruiterCompanyName);
		JSONArray currentListOfApplicants = submittedApplications.getJSONArray(recruiterCompanyName);
		System.out.print("Enter the s.no of the applicant to update the status : ");
		int sNo = sc.nextInt();
		sNo-=1;
		System.out.println();
		JSONObject currentApplicant = (JSONObject) currentListOfApplicants.get(sNo);
		System.out.println("APPLICATION STATUS");
		System.out.println("1. SELECT ");
		System.out.println("2. REJECT ");
		System.out.println("3. PENDING ");
		System.out.print("Enter your choice : ");
		int choice = sc.nextInt();
		System.out.println();
		switch (choice) {
		case 1:

			currentApplicant.put(ApplicantDetails.APPLICATIONSTATUS, "SHORTLISTED");
			currentListOfApplicants.put(sNo, currentApplicant);
			System.out.println("STATUS Updated Sucessfully !!!");
			break;
		case 2:

			currentApplicant.put(ApplicantDetails.APPLICATIONSTATUS, "REJECTED");
			currentListOfApplicants.put(sNo, currentApplicant);
			System.out.println("STATUS Updated Sucessfully !!!");
			break;
		case 3:

			currentApplicant.put(ApplicantDetails.APPLICATIONSTATUS, "PENDING");
			currentListOfApplicants.put(sNo, currentApplicant);
			System.out.println("STATUS Updated Sucessfully !!!");
			break;
		}
	}

	public void viewYourApplication(String userName) {
		int index = 1;
		System.out.println(
				"+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.printf(
				"|  %-6s|     %-30s|     %-5s|     %-15s|    %-15s|     %-30s|     %-20s|     %-10s|     %-10s|     %-20s|     %-20s|     %-20s|\n",
				"S.NO", "NAME OF THE APPLICANT", "AGE", "DATE OF BIRTH", "EXPERIENCE", "EMAIL-ID", "CONTACT NUMBER",
				"ADDRESS", "JOB ID", "JOB DESIGNATION", "COMPANY NAME", "APPLICATION STATUS");
		System.out.println(
				"+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		for (String idOfTheCompany : NewRecruiter.companyNameAndID.keySet()) {
			Object nameOfTheCompany = NewRecruiter.companyNameAndID.get(idOfTheCompany);
			JSONArray currentListOfApplicants = submittedApplications.getJSONArray((String) nameOfTheCompany);
			for (int ind = 0; ind < currentListOfApplicants.length(); ind++) {
				JSONObject currentApplicant = (JSONObject) currentListOfApplicants.get(ind);
				String currentUserName = currentApplicant.getString(ApplicantDetails.USERNAME);
				if (currentUserName.equals(userName)) {
					String currentApplicantName = currentApplicant.getString(ApplicantDetails.NAME);
					int currentAgeOfTheApplicant = currentApplicant.getInt(ApplicantDetails.AGE);
					String currentDOBOfApplicant = currentApplicant.getString(ApplicantDetails.DATEOFBIRTH);
					int currentApplicantExperience = currentApplicant.getInt(ApplicantDetails.EXPERIENCE);
					String currentApplicantEmail = currentApplicant.getString(ApplicantDetails.EMAIL);
					long currentApplicantContactNumber = currentApplicant.getLong(ApplicantDetails.CONTACTNUMBER);
					String currentApplicationAddress = currentApplicant.getString(ApplicantDetails.ADDDRESS);
					int currentjobID = currentApplicant.getInt(ApplicantDetails.JOBID);
					String currentApplicationStatus = currentApplicant.getString(ApplicantDetails.APPLICATIONSTATUS);

					System.out.printf(
							"|  %-6s|     %-30s|     %-5s|     %-15s|    %-15s|     %-30s|     %-20s|     %-10s|     %-10s|     %-20s|     %-20s|     %-20s|\n",
							index++, currentApplicantName, currentAgeOfTheApplicant, currentDOBOfApplicant,
							currentApplicantExperience, currentApplicantEmail, currentApplicantContactNumber,
							currentApplicationAddress, currentjobID, jobDesignation[currentjobID], nameOfTheCompany,
							currentApplicationStatus);

				}
			}

		}
		index = 0;
		System.out.println(
				"+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println();

	}

}