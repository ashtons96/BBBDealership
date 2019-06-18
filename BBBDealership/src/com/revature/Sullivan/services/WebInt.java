package com.revature.Sullivan.services;

import com.revature.Sullivan.BTS.Customers;

public interface WebInt {
	
	public String initialScreen();
	
	public void viewAllPayments();
	
	public void calculateMonthlyPayment(Customers loggedInCustomer);
	
	public void viewCarOfferList();
}
