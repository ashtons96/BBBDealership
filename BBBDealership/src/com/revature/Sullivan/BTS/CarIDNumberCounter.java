package com.revature.Sullivan.BTS;

import java.util.ArrayList;
import java.util.List;

public class CarIDNumberCounter {
	
	private static final List<CarIDNumber> carIdCounter = new ArrayList<>();

	public static List<CarIDNumber> getCaridcounter() {
		return carIdCounter;
	}
}
