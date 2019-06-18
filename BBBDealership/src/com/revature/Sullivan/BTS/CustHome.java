package com.revature.Sullivan.BTS;

import java.util.ArrayList;
import java.util.List;

public class CustHome {
	
	private static final List<Customers> custList = new ArrayList<>();

	public static List<Customers> getCustlist() {
		return custList;
	}
}
