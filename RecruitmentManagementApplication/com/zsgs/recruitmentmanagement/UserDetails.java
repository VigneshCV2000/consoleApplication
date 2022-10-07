package com.zsgs.recruitmentmanagement;

public class UserDetails {
	private String userName;
	private String password;
	private String name;
	private static int temp = 100;
	private int userID = temp++;

	UserDetails(String userName, String password, String name) {
		this.userName = userName;
		this.password = password;
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public int getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

}
