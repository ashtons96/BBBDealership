package com.revature.Sullivan.services;

import java.util.Scanner;

import com.revature.Sullivan.BTS.Car;
import com.revature.Sullivan.BTS.Customers;
import com.revature.Sullivan.BTS.Offers;
import com.revature.Sullivan.BTS.Payment;
import com.revature.Sullivan.DAO.OffersImplPGDAO;
import com.revature.Sullivan.DAO.PaymentsImplPGDAO;
import com.revature.Sullivan.util.LoggingUtil;

public class WebImpl implements WebInt{

	OffersImplPGDAO offersDAO = new OffersImplPGDAO();
	PaymentsImplPGDAO paymentsDAO = new PaymentsImplPGDAO();

	@Override
	public String initialScreen() {
		LoggingUtil.trace("WebServiceImpl - initialScreen(); - start");
		
		System.out.println("WELCOME to the BBB! We specialize in All the Big B's!");

		boolean validInput = false;
		String input = "";


		do {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Are you a Customer or Employee? ");
			System.out.println("Enter '9' to exit.");

			input = scanner.nextLine();

			if (input.equals("Employee") || input.equals("employee")) {
		
				LoggingUtil.trace("WebServiceImpl - input = 'employee'");
				input = "employee";
				validInput = true;
			} else if (input.equals("Customer") || input.equals("customer")) {
				
				LoggingUtil.trace("WebServiceImpl - input = 'customer'");
				input = "customer";
				validInput = true;
			} else if (input.equals("9")) {
				
				LoggingUtil.trace("WebServiceImpl - input = '9'");
				input = "9";
				validInput = true;
			}

		} while (!validInput);

		if (input.equals("9")) {
			System.exit(9);
		}

		return input;
	}

	
	@Override
	public void viewAllPayments() {
		
		LoggingUtil.trace("WebServiceImpl - viewAllPayments(); - start");
		System.out.println("-- View All Payments --");

		if (paymentsDAO.getAllPayments().size() == 0) {
			System.out.println("Payment List is Empty!");
		} else {
			
			for (Car payment : paymentsDAO.getAllPayments()) {
				System.out.println(payment);
			}
		
		}

	}

	@Override
	public void calculateMonthlyPayment(Customers loggedInCustomer) {

		System.out.println("Current Customer Monthly Payment: " + Math.round(loggedInCustomer.getMonthlyPayment()));

		loggedInCustomer.setMonthlyPayment(loggedInCustomer.getBalance() / 12.0);

		System.out.println("New Monthly Customer Monthly Payment: " + Math.round(loggedInCustomer.getMonthlyPayment()));
	}

	@Override
	public void viewCarOfferList() {
		
		LoggingUtil.trace("WebServiceImpl - viewCarOfferList(); - start");
		
		System.out.println("-- See All BBB Offers --");

		if (offersDAO.getAllOffers().size() == 0) {
			
			LoggingUtil.debug("viewCarOfferList -> No BBB Offers");
			
		System.out.println("No BBB Offers Available");
		
		} else {
		
			LoggingUtil.debug("viewCarOfferList -> BBB Offers");
			
			for (Car caroffers : offersDAO.getAllOffers()) {
			
				System.out.println(caroffers);
			}
			
		}

	}

	

}
