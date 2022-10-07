package com.zsgs.recruitmentmanagement;

public class RecruiterDetails {

	private String userName;
	private String password;
	private String recruiterName;
	private static short companyIDGenerator=20221;
	private short companyID=companyIDGenerator++;
	private String companyName;
	private String recruiterEmailID;
	private long recruiterContactNumber;
	private static short recruiterIDGenerator=1;
	private short recruiterID=recruiterIDGenerator++;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public short getCompanyID() {
		return companyID;
	}

	public void setCompanyID(short companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRecruiterEmailID() {
		return recruiterEmailID;
	}

	public void setRecruiterEmailID(String recruiterEmailID) {
		this.recruiterEmailID = recruiterEmailID;
	}

	public long getRecruiterContactNumber() {
		return recruiterContactNumber;
	}

	public void setRecruiterContactNumber(long recruiterContactNumber) {
		this.recruiterContactNumber = recruiterContactNumber;
	}

	public short getRecruiterID() {
		return recruiterID;
	}

	public void setRecruiterID(short recruiterID) {
		this.recruiterID = recruiterID;
	}

}
