package com.zsgs.recruitmentmanagement;

public class Validations {

	public boolean jobIDValidation(int jobID) {
		if(jobID>=1||jobID<=8) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean editJobDetailsOptionValidation(int option) {
		if(option==1||option==2) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean nameValidation(String name) {
		return name.matches("^[aA-zZ][aA-zZ\\s.]{2,29}$");
	}

	public boolean numberValidation(long number) {

		return String.valueOf(number).matches("^[6789][0-9]{9}$");
	}

	public boolean passwordValidation(String password) {
		return password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}");
	}
	
	public boolean passwordValidationForRecruiter(String password , String username) {
		
		return password.equals("Admin@2022")&&username.equals("Recruiter");
	}
	
	public boolean emailValidation(String email) {
		return email.matches("^[a-z][a-z0-9+_.-]+@(.+)$");
	}
	
	public boolean userNameValidation(String username) {
		return username.matches("^[aA-zZ][aA-zZ\\s.]{2,29}$");
	}
	
	

}
