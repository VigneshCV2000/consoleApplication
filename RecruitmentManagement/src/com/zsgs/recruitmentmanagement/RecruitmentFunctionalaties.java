package com.zsgs.recruitmentmanagement;

import java.util.Scanner;

import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class RecruitmentFunctionalaties {

	JobDetails jobDetails;
	Scanner sc = new Scanner(System.in);

	Validations validation = new Validations();
	int jobID;
	int jobExperienceRequirement;
	String jobDiscription;
	String jobName;

	public void createJobDetails(String companyName) {

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
		System.out.print("Enter the new job designation you want to add : ");
		jobID = sc.nextInt();
		System.out.println();
		while (!validation.jobIDValidation(jobID)) {
			System.out.print("Enter a valid JobID :");
			jobID = sc.nextInt();
		}
		JSONArray companyOpenings = NewRecruiter.companyList.getJSONArray(companyName);
		int jobIDInList = -1;
		Iterator it = companyOpenings.iterator();
		while (it.hasNext()) {
			JSONObject opening = (JSONObject) it.next();
			jobIDInList = opening.getInt(JobDetails.JOBID);
			if (jobIDInList == jobID) {
				break;
			}
		}
		if (jobID == jobIDInList) {
			System.err.println("This job designation already exists in the the list.");
		} else {

			switch (jobID) {
			case 1:
				jobName = "Software Developer";
				jobAddingProcess(jobID, jobName, companyName);
				System.out.println("Software Developer is sucessfully added to the job list");
				System.out.println();
				break;
			case 2:
				jobName = "QA Engineer";
				jobAddingProcess(jobID, jobName, companyName);
				System.out.println("QA Engineer is sucessfully added to the job list");
				System.out.println();
				break;
			case 3:
				jobName = "Web Developer";
				jobAddingProcess(jobID, jobName, companyName);
				System.out.println("Web Developer is sucessfully added to the job list");
				System.out.println();
				break;
			case 4:
				jobName = "Sales Executive";
				jobAddingProcess(jobID, jobName, companyName);
				System.out.println("Sales Executive is being sucessfully added to the job list");
				System.out.println();
				break;
			case 5:
				jobName = "Content Writer";
				jobAddingProcess(jobID, jobName, companyName);
				System.out.println("Content Writer is being sucessfully added to the job list");
				System.out.println();
				break;
			case 6:
				jobName = "Designer-UI/UX";
				jobAddingProcess(jobID, jobName, companyName);
				System.out.println("Designer-UI/UX is being sucessfully added to the job list");
				System.out.println();
				break;
			case 7:
				jobName = "Technical Support Engineer";
				jobAddingProcess(jobID, jobName, companyName);
				System.out.println("Technical Support Engineer is being sucessfully added to the job list");
				System.out.println();
				break;
			case 8:
				jobName = "Product Marketer";
				jobAddingProcess(jobID, jobName, companyName);
				System.out.println("Product Marketer is being sucessfully added to the job list");
				System.out.println();
				break;
			}

		}

	}

	public void showJobsDetails(String companyName) {
		JSONArray companyOpenings = NewRecruiter.companyList.getJSONArray(companyName);
		if (companyOpenings.length() == 0) {
			System.err.print("\nThere are no openings currently\n");
		} else {

			System.out.println(
					"+-----------------------------------------------------------------------------------------------------------------------------------+");
			System.out.printf("|        %-15s|        %-30s|        %-25s|         %-25s|\n", "JOB ID", "JOB NAME",
					"JOB DESCRIPTION", "JOB EXPERIENCE");
			System.out.println(
					"+-----------------------------------------------------------------------------------------------------------------------------------+");
			Iterator it = companyOpenings.iterator();
			while (it.hasNext()) {
				JSONObject opening = (JSONObject) it.next();
				jobName = opening.getString(JobDetails.JOBNAME);
				jobID = opening.getInt(JobDetails.JOBID);
				jobExperienceRequirement = opening.getInt(JobDetails.EXPERIENCE);
				jobDiscription = opening.getString(JobDetails.JOBDESCRIPTION);
				System.out.printf("|        %-15s|        %-30s|        %-25s|         %-25s|\n", jobID, jobName,
						jobDiscription, jobExperienceRequirement);
			}
			System.out.println(
					"+-----------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println();

		}

	}

	public void editJobsDetails(String companyName) {
		int jobID;
		JSONArray companyOpenings = NewRecruiter.companyList.getJSONArray(companyName);
		if (companyOpenings.length() == 0) {
			System.out.println("\nThere is no designation present in the JobList\n");
			return;
		}
		showJobsDetails(companyName);
		System.out.print("Enter the jobID you want to edit :");
		jobID = sc.nextInt();
		while (!validation.jobIDValidation(jobID)) {
			System.out.print("Enter a valid JobID :");
			jobID = sc.nextInt();
		}
		boolean flag = false;
		for (int i = 0; i < companyOpenings.length(); i++) {
			JSONObject opening = (JSONObject) companyOpenings.get(i);
			int currentjobID = opening.getInt(JobDetails.JOBID);
			if (currentjobID == jobID) {
				jobName = opening.getString(JobDetails.JOBNAME);
				System.out.print("Edit your job description :");
				jobDiscription = sc.next();
				System.out.print("Edit your job experiencerequirement :");
				jobExperienceRequirement = sc.nextInt();
				JSONObject editedOpening = new JSONObject();
				editedOpening.put(JobDetails.JOBID, jobID);
				editedOpening.put(JobDetails.JOBNAME, jobName);
				editedOpening.put(JobDetails.EXPERIENCE, jobExperienceRequirement);
				editedOpening.put(JobDetails.JOBDESCRIPTION, jobDiscription);
				companyOpenings.put(i, editedOpening);
				flag = true;
			}
		}
		if (flag == true) {
			System.out.println("Job Details for " + jobName + " is edited Sucessfully");
			System.out.println(jobID + " " + jobName + " " + " " + jobDiscription + " " + jobExperienceRequirement);
		}

		else {
			System.out.println("\nJob opening not found\n");
		}
	}

	public void removeJobDetails(String companyName) {
		JSONArray companyOpenings = NewRecruiter.companyList.getJSONArray(companyName);
		if (companyOpenings.length() == 0) {
			System.out.println("\nThere is no designation present in the JobList\n");
			return;
		}
		boolean flag = false;
		showJobsDetails(companyName);
		System.out.println("Enter the Job Designation which you want to remove : ");
		int jobID = sc.nextInt();
		System.out.println();
		for (int i = 0; i < companyOpenings.length(); i++) {
			JSONObject opening = (JSONObject) companyOpenings.get(i);
			int currentjobID = opening.getInt(JobDetails.JOBID);
			if (currentjobID == jobID) {
				jobName = opening.getString(JobDetails.JOBNAME);
				companyOpenings.remove(i);
				flag = true;
				break;
			}
			if (flag == true) {
				System.out.println(jobName + " is removed sucessfully !\n");
			} else {
				System.out.println("JobID not available !");
			}
		}
		System.out.println(jobID + " is removed sucessfully !");
		System.out.println();

	}

	public void jobAddingProcess(int jobID, String jobDesignation, String companyName) {

		System.out.print("Enter the Experience requirement : ");
		jobExperienceRequirement = sc.nextInt();
		System.out.println();
		System.out.print("Enter the job description : ");
		jobDiscription = sc.next();
		System.out.println();
		JSONObject jobDetails = new JSONObject();
		jobDetails.put(JobDetails.JOBID, jobID);
		jobDetails.put(JobDetails.JOBNAME, jobDesignation);
		jobDetails.put(JobDetails.EXPERIENCE, jobExperienceRequirement);
		jobDetails.put(JobDetails.JOBDESCRIPTION, jobDiscription);

		JSONArray jobList = NewRecruiter.companyList.getJSONArray(companyName);
		jobList.put(jobDetails);
		NewRecruiter.companyList.put(companyName, jobList);
	}

	public void viewApplicants(String recruiterCompanyName) {
		ApplicationProcess applicationProcess = new ApplicationProcess();
		applicationProcess.showApplicants(recruiterCompanyName);
	}
	
	public void reviewApplicants(String recruiterCompanyName) {
		ApplicationProcess applicationProcess = new ApplicationProcess();
		applicationProcess.reviewApplication(recruiterCompanyName);
	}

	public boolean checkEligiliblityCriteria(int experience, int jobID, String companyName) {
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
		return flag;
	}

}
