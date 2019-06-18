package com.revature.Sullivan.BTS;

import java.util.ArrayList;
import java.util.List;

public class OrderCounter {

	private static final List<OrderNumber> OrderCounter = new ArrayList<>();

	public static List<OrderNumber> getUniqeidcounter() {
		return OrderCounter;
	}
}
