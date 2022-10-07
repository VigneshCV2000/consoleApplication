package com.zsgs.recruitmentmanagement;

public class JobDetails {
	private String jobName;
	private int jobId;
	private int experience;
	private String jobDiscription;

	public JobDetails(int jobExperienceRequirement, String jobDiscription, String jobName, int jobId) {
		this.experience = jobExperienceRequirement;
		this.jobDiscription = jobDiscription;
		this.jobName = jobName;
		this.jobId = jobId;
	}

	public String getJobDiscription() {
		return jobDiscription;
	}

	public String getJobName() {
		return jobName;
	}

	public int getExperience() {
		return experience;
	}

	public int getJobId() {
		return jobId;
	}

}
