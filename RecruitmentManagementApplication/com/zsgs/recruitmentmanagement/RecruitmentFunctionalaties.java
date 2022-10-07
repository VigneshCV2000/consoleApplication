package com.zsgs.recruitmentmanagement;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map;

public class RecruitmentFunctionalaties {

	static TreeMap<Integer, JobDetails> jobList;

	RecruitmentFunctionalaties() {
		jobList = new TreeMap<Integer, JobDetails>();
	}

	JobDetails jobDetails;
	Scanner sc = new Scanner(System.in);

	Validations validation = new Validations();
	int jobID;
	int jobExperienceRequirement;
	String jobDiscription;
	String jobName;

	public void createJobDetails() {

		System.out.println("+--------------------------------------------------+");
		System.out.println("|                JOB DESIGNATIONS                  |");
		System.out.println("+--------------------------------------------------+");
		System.out.printf("|%50s|%n", "");
		System.out.println("|              1.Software Developer                |");
		System.out.println("|              2.QA Engineer                       |");
		System.out.println("|              3.Web Developer                     |");
		System.out.println("|              4.Sales Executive                   |");
		System.out.println("|              5.Content Writer                    |");
		System.out.println("|              6.Designers-UI/UX                   |");
		System.out.println("|              7.Technical Support Engineer        |");
		System.out.println("|              8.Product Marketer                  |");
		System.out.printf("|%50s|%n", "");
		System.out.println("+--------------------------------------------------+");
		System.out.println();
		System.out.println("Enter the new job designation you want to add :");
		jobID = sc.nextInt();
		while (!validation.jobIDValidation(jobID)) {
			System.out.print("Enter a valid JobID :");
			jobID = sc.nextInt();
		}
		if (jobList.containsKey(jobID)) {
			System.out.println("This job designation already exists in the the list.");
		} else {

			switch (jobID) {
			case 1:
				jobName = "Software Developer";
				jobAddingProcess(jobID, jobName);
				System.out.println("Software Developer is sucessfully added to the job list");
				System.out.println();
				break;
			case 2:
				jobName = "QA Engineer";
				jobAddingProcess(jobID, jobName);
				System.out.println("QA Engineer is sucessfully added to the job list");
				System.out.println();
				break;
			case 3:
				jobName = "Web Developer";
				jobAddingProcess(jobID, jobName);
				System.out.println("Web Developer is sucessfully added to the job list");
				System.out.println();
				break;
			case 4:
				jobName = "Sales Executive";
				jobAddingProcess(jobID, jobName);
				System.out.println("Sales Executive is being sucessfully added to the job list");
				System.out.println();
				break;
			case 5:
				jobName = "Content Writer";
				jobAddingProcess(jobID, jobName);
				System.out.println("Content Writer is being sucessfully added to the job list");
				System.out.println();
				break;
			case 6:
				jobName = "Designer-UI/UX";
				jobAddingProcess(jobID, jobName);
				System.out.println("Designer-UI/UX is being sucessfully added to the job list");
				System.out.println();
				break;
			case 7:
				jobName = "Technical Support Engineer";
				jobAddingProcess(jobID, jobName);
				System.out.println("Technical Support Engineer is being sucessfully added to the job list");
				System.out.println();
				break;
			case 8:
				jobName = "Product Marketer";
				jobAddingProcess(jobID, jobName);
				System.out.println("Product Marketer is being sucessfully added to the job list");
				System.out.println();
				break;
			}

		}

	}

	public void showJobsDetails() {
		if (jobList.size() == 0) {
			System.out.print("\nThere are no openings currently\n");
		} else {

			System.out.println(
					"+-----------------------------------------------------------------------------------------------------------------------------------+");
			System.out.printf("|        %-15s|        %-30s|        %-25s|         %-25s|\n", "JOB ID", "JOB NAME",
					"JOB DESCRIPTION", "JOB EXPERIENCE");
			System.out.println(
					"+-----------------------------------------------------------------------------------------------------------------------------------+");
			for (Map.Entry<Integer, JobDetails> entry : jobList.entrySet()) {
				int id = entry.getKey();
				JobDetails jobInfo = entry.getValue();
				jobName = jobInfo.getJobName();
				jobExperienceRequirement = jobInfo.getExperience();
				jobDiscription = jobInfo.getJobDiscription();
				System.out.printf("|        %-15s|        %-30s|        %-25s|         %-25s|\n", id, jobName,
						jobDiscription, jobExperienceRequirement);
//				System.out.println("              " + id + "." + jobName + "            ");
			}
//			System.out.println();
			System.out.println(
					"+-----------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println();

		}

	}

	public void editJobsDetails() {
		int jobID;
		if (jobList.size() == 0) {
			System.out.println("\nThere is no designation present in the JobList\n");
			return;
		}
		showJobsDetails();
		System.out.print("Enter the jobID you want to edit :");
		jobID = sc.nextInt();
		while (!validation.jobIDValidation(jobID)) {
			System.out.print("Enter a valid JobID :");
			jobID = sc.nextInt();
		}
		JobDetails JobInfo = jobList.get(jobID);
		jobName = JobInfo.getJobName();
		System.out.print("Edit your job description :");
		jobDiscription = sc.next();
		System.out.print("Edit your job experiencerequirement :");
		jobExperienceRequirement = sc.nextInt();
		JobDetails editedJobDetails = new JobDetails(jobExperienceRequirement, jobDiscription, jobName, jobID);
		jobList.put(jobID, editedJobDetails);
		System.out.println("Job Details for " + jobName + " is edited Sucessfully");
		System.out.println(jobID + " " + jobName + " " + " " + jobDiscription + " " + jobExperienceRequirement);

	}

	public void removeJobDetails() {
		if (jobList.size() == 0) {
			System.out.println("\nThere is no designation present in the JobList\n");
			return;
		}
		showJobsDetails();
		System.out.println("Enter the Job Designation which you want to remove : ");
		int jobID = sc.nextInt();
		System.out.println();
		while (!validation.jobIDValidation(jobID)) {
			System.out.print("You Entered an invalid jobID . Enter a valid JobID :");
			jobID = sc.nextInt();
		}
		jobList.remove(jobID);
		System.out.println(jobID + " is removed sucessfully !");
		System.out.println();

	}

	public void jobAddingProcess(int jobID, String jobDesignation) {

		System.out.print("Enter the Experience requirement : ");
		jobExperienceRequirement = sc.nextInt();
		System.out.println();
		System.out.print("Enter the job description : ");
		jobDiscription = sc.next();
		System.out.println();
		jobDetails = new JobDetails(jobExperienceRequirement, jobDiscription, jobDesignation, jobID);
		jobList.put(jobID, jobDetails);
	}

	public void viewApplicants() {
		ApplicationProcess applicationProcess = new ApplicationProcess();
		applicationProcess.showApplicants();
	}

	public boolean checkJobAvailability() {
		if (jobList.size() == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
}
