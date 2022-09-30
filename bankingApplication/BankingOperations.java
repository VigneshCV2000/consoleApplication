package com.bankingapplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankOperations {

	Map<String, UserDetails> customerDetails;

	BankOperations() {
		customerDetails = new HashMap<String, UserDetails>();
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		BankOperations bank = new BankOperations();
		Validation valid = new Validation();
		UserDetails user;
//		BankingFunctions bankFunc=new BankingFunctions();

		outer: while (true) {

			System.out.println("+*************************************************+");
			System.out.println("|              Welcome to Canara Bank             |");
			System.out.println("+*************************************************+");
			System.out.println();
			System.out.println("              1. Create Account                  ");
			System.out.println("              2. Login                           ");
			System.out.println("              3. Exit                            ");
			System.out.println();
			System.out.println("*************************************************");
			System.out.println();
			System.out.println("Enter your choice :");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:

				System.out.println("Enter your name:");
				String name = sc.nextLine();
				while (!valid.nameValidation(name)) {
					System.out.println("Invalid name ! Enter a valid name:");
					name = sc.nextLine();
				}
				System.out.println();
				System.out.println("Enter your mobile number :");
				long mobileNumber = sc.nextLong();
				while (!valid.numberValidation(mobileNumber)) {
					System.out.println("Invalid Mobile number! Enter a valid mobile number :");
					mobileNumber = sc.nextLong();
				}
				System.out.println();
				System.out.println("Set an username          :");
				String username = sc.next();
				while (bank.customerDetails.containsKey(username)) {
					System.out.println("The username already exist");
					System.out.println("Set the username again");
					username = sc.next();
				}

				System.out.println("Password costraints      :");
				System.out.println("Minimum 8 characters ");
				System.out.println("Minimum contains 1 digit      ");
				System.out.println("Minimum contains 1 uppercase alphabet ");
				System.out.println("Minimum contains 1 lowercase alphabet ");
				System.out.println("Minimum contains 1 special character like (!@#$%^&*_) ");
				System.out.println("Set a password           :");
				String password = sc.next();
				while (!valid.passwordValidation(password)) {
					System.out.println("Set a Valid password");
					password = sc.next();
				}
				System.out.println("Enter your initial deposite amount :");
				double amount = sc.nextDouble();
				while (amount < 0) {
					System.out.println("The amount you entered is invalid ! Enter a valid deposite amount :");
					amount = sc.nextDouble();
				}
				user = new UserDetails(name, username, password, mobileNumber, amount);
				System.out.println("Your Generated Account number is :" + user.getAccountNumber());
				bank.customerDetails.put(username, user);
				break;

			case 2:
				System.out.println("Enter username :");
				username = sc.next();
				System.out.println("Enter the password :");
				password = sc.next();
				if (bank.customerDetails.containsKey(username)) {
					var currentUser = bank.customerDetails.get(username);
					String passwordMatcher = currentUser.getPassword();
					if (password.equals(passwordMatcher)) {
						while (true) {
							System.out.println("*************************************************");
							System.out.println("             Welcome " + currentUser.getName());
							System.out.println("*************************************************");
							System.out.println("               1.Check Balance                   ");
							System.out.println("               2.Deposite Amount                 ");
							System.out.println("               3.Withdraw Amount                 ");
							System.out.println("               4.Transfer Amount                 ");
							System.out.println("               5.Logout                          ");
							System.out.println("*************************************************");

							System.out.println("Enter your choice :");
							int option = sc.nextInt();
							switch (option) {
							case 1:
								System.out.println("The current balance :" + currentUser.getBalance());
								break;
							case 2:
								System.out.println("Enter the amount to be deposited to your account :");
								double depositeAmt = sc.nextDouble();
								if (depositeAmt > 0) {
									currentUser.deposite(depositeAmt);
								} else {
									System.out.println(
											"The amount you entered is invalid ! Enter a valid deposite amount :");
									depositeAmt = sc.nextDouble();
								}
								break;
							case 3:
								System.out.println("Enter the amount to withdraw from your account :");
								double withDrawAmt = sc.nextDouble();
								currentUser.withDraw(withDrawAmt);
								break;
							case 4:
								System.out.println("Enter the username of the account to transefer the money");
								String payeeUserName = sc.next();
								while (!bank.customerDetails.containsKey(payeeUserName)) {
									System.out.println("Invalid username ! Enter a valid username :");
									payeeUserName = sc.next();
								}
								var payeeUser = bank.customerDetails.get(payeeUserName);
								currentUser.transferAmount(username, payeeUserName, currentUser, payeeUser);
								break;
							case 5:
								System.out.println(" Thank you for using our banking service ");
								continue outer;

							}

						}
					} else {
						System.out.println("Your password is incorrect!");
					}

				}
			}
		}

	}
}
