package com.revature.Sullivan.screens;

import java.util.Scanner;

import com.revature.Sullivan.BTS.Employees;
import com.revature.Sullivan.services.EmpServiceImpl;
import com.revature.Sullivan.services.LotImpl;
import com.revature.Sullivan.services.WebImpl;
import com.revature.Sullivan.util.LoggingUtil;

public class ScreenEmp implements ScreenUser {
	private LotImpl l = new LotImpl();
	private WebImpl w = new WebImpl();
	private EmpServiceImpl e = new EmpServiceImpl();
	

	@Override
	public boolean display() {
		LoggingUtil.trace("Employee Screen - display(); - start");

		if (!verifyLogin()) {
			LoggingUtil.trace("false employee login verification");
			return false;
		}

		boolean exitInput = true;
		String input = "";

		do {

			LoggingUtil.trace("do loop - EmployeeScreen - start");


			Scanner scanner = new Scanner(System.in);
			System.out.println("\nWelcome! What would you like to do today?");

			System.out.println("Enter '1' to Bring in a new BBB ");
			System.out.println("Enter '2' to accept or reject BBB offers.");
			System.out.println("Enter '3' to remove a BBB from the Lot");
			System.out.println("Enter '4': View all payments");
			System.out.println("Enter '9': Exit!");

			input = scanner.nextLine();

			switch (input) {
			case "1":
				
				LoggingUtil.trace("do loop - employee menu - calling addCar();");
				
				l.addCar();
			
				exitInput = false;
				break;
				
			case "2":
				
				LoggingUtil.trace("do loop - employee menu  - calling addCar();");
				
				e.offerDecisionMenu();
				
				exitInput = false;
				break;
			
			case "3":
				LoggingUtil.trace("do loop - employee menu  - calling removeCar();");
				
				l.removeCarMenu();
				
				exitInput = false;
			
				break;
			
			case "4":
				
				LoggingUtil.trace("do loop - employee menu  - calling viewAllPayments();");
			
				w.viewAllPayments();
				
				exitInput = false;
				
				break;
		
			case "9":
				
				LoggingUtil.trace("do loop - employee menu  - exiting");
				
				exitInput = true;


				break;
			}

		} while (!exitInput);

		return false;
	}

	@Override
	public boolean verifyLogin() {

		LoggingUtil.trace("employee loginVerification(); - start");

		int counter = 0;

		String username = "";
		boolean verifiedUsername = false;
		
		String password = "";
		boolean verifiedPassword = false;

		do {

			Scanner scanner = new Scanner(System.in);
			counter = 0;

			System.out.println("Enter '9' to Go Back");

			System.out.println("Username:  ");
			username = scanner.nextLine();

			if (username.equals("9")) {
				break;
			}

			if (username.equals(Employees.getEmployee().getUSERNAME())) {
				
				LoggingUtil.trace("employee username correct");
				
				verifiedUsername = true;
				counter++;
			}

			
			System.out.println("Password: ");
			password = scanner.nextLine();

			if (password.equals(Employees.getEmployee().getPASSWORD())) {
				
				LoggingUtil.trace("employee password correct");
				verifiedPassword = true;
				counter++;
			}

		} while (!verifiedUsername && !verifiedPassword);

		if (counter == 2) {
			
			LoggingUtil.trace("login failed");
			
			return true;
			
			
		} else {
			
			LoggingUtil.trace("login passed");
			
			return false;
		}

	}


}
