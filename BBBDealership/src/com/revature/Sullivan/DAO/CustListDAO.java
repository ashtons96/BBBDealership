package com.revature.Sullivan.DAO;

import java.util.List;

import com.revature.Sullivan.BTS.Customers;

public interface CustListDAO {

	public void saveCustomerList(List<Customers> custList);
	
	public List<Customers> loadCustomerList();


}
