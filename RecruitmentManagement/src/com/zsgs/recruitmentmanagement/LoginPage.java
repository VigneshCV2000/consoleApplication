package com.zsgs.recruitmentmanagement;

import java.util.Scanner;

import org.json.JSONObject;

public class LoginPage {

	RecruitmentFunctionalaties recruitFunctions = new RecruitmentFunctionalaties();
	Scanner sc = new Scanner(System.in);

	public void loginForRecruiter(JSONObject recruiterDetails) {

		String recruiterCompanyName = recruiterDetails.getString(RecruiterDetails.RECRUITERCOMPANYNAME);
		WHILE: while (true) {
			try {
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("|                     WELCOME RECRUITER                          |");
				System.out.println("+----------------------------------------------------------------+");
				System.out.printf("|%64s|%n", "");
				System.out.printf(
						"|              %-50s|%n|              %-50s|%n|              %-50s|%n|              %-50s|%n|              %-50s|%n|              %-50s|%n|              %-50s|%n",
						"1. ADD JOB REQUIREMENT", "2. SHOW THE AVAILABLE JOB REQUIREMENT", "3. EDIT THE JOB REQUIREMENT",
						"4. REMOVE THE JOB REQUIREMENT", "5. VIEW APPLICANTS", "6. REVIEW APPLICANTS","7. LOGOUT");
				System.out.printf("|%64s|%n", "");
				System.out.println("+----------------------------------------------------------------+");
				System.out.println();
				System.out.print("Enter your choice :");
				int choice = new Scanner(System.in).nextInt();
				System.out.println();
				if (choice < 1 || choice > 7)
					throw new Exception();

				switch (choice) {
				case 1:

					recruitFunctions.createJobDetails(recruiterCompanyName);
					break;
				case 2:
					recruitFunctions.showJobsDetails(recruiterCompanyName);
					break;
				case 3:
					recruitFunctions.editJobsDetails(recruiterCompanyName);
					break;
				case 4:
					recruitFunctions.removeJobDetails(recruiterCompanyName);
					break;
				case 5:
					recruitFunctions.viewApplicants(recruiterCompanyName);
					break;
				case 6:
					recruitFunctions.reviewApplicants(recruiterCompanyName);
					break;
				case 7:
					break WHILE;
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("\nYou have entered an invalid option\n");
			}

		}

	}

}
