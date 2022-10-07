package com.zsgs.recruitmentmanagement;

public class ApplicantDetails {
	private String userName;
	private String name;
	private int age;
	private String dateOfBirth;
	private int experience;
	private String email;
	private long contactNumber;
	private String address;
	private int jobID;

	ApplicantDetails() {

	}

	ApplicantDetails(String userName, String name, int age, String dob, int experience, String email,
			long contactNumber, String address, int jobID) {
		this.userName = userName;
		this.name = name;
		this.age = age;
		this.dateOfBirth = dob;
		this.experience = experience;
		this.email = email;
		this.contactNumber = contactNumber;
		this.address = address;
		this.jobID = jobID;

	}

	public String getUserName() {
		return userName;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public int getExperience() {
		return experience;
	}

	public String getEmail() {
		return email;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public int getJobID() {
		return jobID;
	}

}
