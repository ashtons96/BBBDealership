package com.revature.Sullivan.DAO;

import java.util.List;

import com.revature.Sullivan.BTS.Car;
import com.revature.Sullivan.BTS.Customers;

public interface CarDAOSQL {

		public int insertCar(Car car);

		public void updateCarOnAcceptOffer(Car car, Customers customer);
		
		public void updateCarOnRemoval(Car car);

		public List<Car> getAllCars();

		public List<Car> getCarsByCustomerId(int id);
		
		public Car getCarById(int id);

}
