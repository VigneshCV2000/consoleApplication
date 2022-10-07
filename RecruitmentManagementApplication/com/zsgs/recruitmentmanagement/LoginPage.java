package com.zsgs.recruitmentmanagement;

import java.util.Scanner;

public class LoginPage {

	RecruitmentFunctionalaties recruitFunctions = new RecruitmentFunctionalaties();
//	ApplicationProcess applicationProcess=new ApplicationProcess();
	Scanner sc = new Scanner(System.in);

	public void loginForRecruiter() {
		WHILE:
		while (true) {
			try {
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("|                     WELCOME RECRUITER                          |");
				System.out.println("+----------------------------------------------------------------+");
				System.out.printf("|%64s|%n", "");
				System.out.printf(
						"|              %-50s|%n|              %-50s|%n|              %-50s|%n|              %-50s|%n|              %-50s|%n|              %-50s|%n",
						"1.ADD JOB REQUIREMENT", "2.SHOW THE AVAILABLE JOB REQUIREMENT", "3.EDIT THE JOB REQUIREMENT",
						"4.REMOVE THE JOB REQUIREMENT", "5.VIEW APPLICANTS", "6.LOGOUT");
				System.out.printf("|%64s|%n", "");
				System.out.println("+----------------------------------------------------------------+");
				System.out.println();
				System.out.print("Enter your choice :");
				int choice = new Scanner(System.in).nextInt();
				System.out.println();
				if(choice<1 || choice>6)throw new Exception();
				
				switch (choice) {
				case 1:

					recruitFunctions.createJobDetails();
					break;
				case 2:
					recruitFunctions.showJobsDetails();
					break;
				case 3:
					recruitFunctions.editJobsDetails();
					break;
				case 4:
					recruitFunctions.removeJobDetails();
					break;
				case 5:
					recruitFunctions.viewApplicants();
					break;
				case 6:
					break WHILE;
				}

			}catch(Exception e) {
				System.out.println("\nYou have entered an invalid option\n");
			}
				
			}

	}

}
