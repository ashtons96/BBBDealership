package com.revature.Sullivan.DAO;

import java.util.List;

import com.revature.Sullivan.BTS.Car;

public interface LotDAO {
	
	public void saveCarLot(List<Car> carLot);
	
	public List<Car> loadCarLot();
}
