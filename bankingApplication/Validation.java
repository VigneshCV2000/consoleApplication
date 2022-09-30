package com.bankingapplication;

import java.util.regex.*;

public class Validation {
	public boolean nameValidation(String name) {
		return name.matches("^[aA-zZ][aA-zZ\\s.]{2,29}$");
	}

	public boolean numberValidation(long number) {

		return String.valueOf(number).matches("^[6789][0-9]{9}$");
	}

	public boolean passwordValidation(String password) {
		return password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}");
	}

}
