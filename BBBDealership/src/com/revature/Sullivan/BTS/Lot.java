package com.revature.Sullivan.BTS;

import java.util.ArrayList;
import java.util.List;

public class Lot {
	
	private static final List<Car> Lot = new ArrayList<>();

	public static List<Car> getLot() {
		return Lot;
	}
}
