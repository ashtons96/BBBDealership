package com.revature.Sullivan.services;

import com.revature.Sullivan.BTS.Customers;

public interface CustServiceInt {

	public void makeOffer(Customers loggedInCustomer);
	
	public void viewOwnedCars(Customers loggedInCustomer);
	
	public void viewRemainingPayments(Customers loggedInCustomer);
	
	public void viewLocalPaymentsMade(Customers loggedInCustomer);
}
