package com.revature.Sullivan.DAO;


import java.util.List;

import com.revature.Sullivan.BTS.CarIDNumber;

public interface CarIDNumbersDAO {

	public void saveCarIDNumbers(List<CarIDNumber> CarIDNumber);
	
	public List<CarIDNumber> loadCarIDNumbers();
}
