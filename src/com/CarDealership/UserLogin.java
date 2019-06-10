package com.CarDealership;

import java.util.Scanner;

public class UserLogin extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Scanner choice;
	private static Scanner sc;
	private static Scanner sc2;

	//public static void main(String[] args) {

		

	public static void doLogIn() {
		
		boolean exitInput = false;

		do {
			choice = new Scanner(System.in);
			String uChoice = new String();

			System.out.println("Customer or Employee");
			
			uChoice = choice.nextLine();
			
			if (uChoice.equals("Employee")) {
				//call employee login method//
				UserLogin.EmployeeLogIn();
				exitInput = true;
			} else if (uChoice.equals("Customer")) {
				//call customer login
			UserLogin.CustomerLogIn();
			exitInput =  true;
			}
			if ((uChoice != "Employee") && (uChoice != "Customer")) {
				System.out.println("Please repeat choice");
			}
		} while (exitInput == false); 
		
	}
	
	public static boolean EmployeeLogIn() {
		Boolean input = false;
		
		do {
		sc = new Scanner(System.in);
		
		String employeeUserN, employeePassW;
		employeeUserN = "Admin";
		employeePassW = "Admin";
		
		System.out.println("Username: ");
		String employeeUsername = sc.next();
		
		System.out.println("Password: ");
		String employeePassword = sc.next();		
		
		if (employeeUserN.equals(employeeUsername) && (employeePassW.equals(employeePassword))) {
			System.out.println("You are logged In");
		}
		while ((!employeeUserN.equals(employeeUserN)) && (!employeePassW.equals(employeePassW)) 
				|| (!employeeUserN.equals(employeeUserN)) && (employeePassW.equals(employeePassW))
				|| (employeeUserN.equals(employeeUserN)) && (!employeePassW.equals(employeePassW))) {
			System.out.println("Incorrect. Try Again!");
		}
		} while (!input);
		return false; 
	}
	
	public static boolean CustomerLogIn() {
		
		Boolean input = false;
		do {
		sc2 = new Scanner(System.in);
		String userN, passW;
		
		userN = "Customer";
		passW = "Password";
		
		System.out.println("Username: ");
		String inputUsername = sc2.next();
		
		System.out.println("Password: ");
		String inputPassword = sc2.next();
		
		if (userN.equals(inputUsername) && (passW.equals(inputPassword))) {
			input = true;
			System.out.println("Welcome! You are logged In");
		}
		while ((!userN.equals(userN) && (!passW.equals(passW)) || 
				(!userN.equals(userN)) && (passW.equals(passW)) || 
				(!userN.equals(userN)) && (!passW.equals(passW)))) {
			System.out.println("Incorrect. Try Again!");
		}
		}while(!input);
		return false;
	}
		
}

