package com.bankingapplication;

import java.util.Scanner;

public class UserDetails {

	private String name;
	private String userName;
	private String password;
	private long phoneNumber;
	private double balance;
	private static long tempId = 73200026;
	private long accNo = tempId++;

	UserDetails(String name, String userName, String password, long phoneNumber, double balance) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public double getBalance() {
		return balance;
	}

	public long getAccountNumber() {
		return accNo;
	}

	Scanner sc = new Scanner(System.in);

	public void deposite(double amount) {
		balance += amount;
		System.out.println(amount + " is credited to your account ");
		System.out.println("Current balance in your account :" + balance);
	}

	public void withDraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println(amount + " is debited from your account ");
			System.out.println("Current balance in your account :" + balance);
		} else {
			System.out.println("Your account has insufficient balance :");
			System.out.println("Current balance in your account :" + balance);
		}

	}

	public void transferAmount(String currentUserName, String payeeUserName, UserDetails currentUser,
			UserDetails payeeUser) {

		System.out.println("Enter the amount you want to transfer to :" + payeeUser.getName());
		double tansferAmt = sc.nextDouble();
		while (tansferAmt < 0) {
			System.out.println("Invalid transfer amount !Enter a valid transfer amount");
			tansferAmt = sc.nextDouble();
		}
		while (currentUser.getBalance() < tansferAmt) {
			System.out.println("You have an insufficient balance.");
			System.out.println("Your current balance is " + currentUser.getBalance());
			System.out.println("Enter a valid transfer amount");
			tansferAmt = sc.nextDouble();
			while (tansferAmt < 0) {
				System.out.println("Invalid transfer amount !Enter a valid transfer amount");
				tansferAmt = sc.nextDouble();
			}
		}

		currentUser.balance = currentUser.getBalance() - tansferAmt;
		payeeUser.balance = payeeUser.getBalance() + tansferAmt;
		System.out.println(tansferAmt + " is debited from your account");
		System.out.println("Your current balance is :" + currentUser.getBalance());
	}

}
