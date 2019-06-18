package com.revature.Sullivan.BTS;

import java.util.ArrayList;
import java.util.List;

public class PaymentList {
	
	private static final List<Payment> PaymentList = new ArrayList<>();

	public static List<Payment> getMasterPaymentList() {
		return PaymentList;
	}

}
