package com.revature.Sullivan.services;

import java.util.Scanner;

import com.revature.Sullivan.BTS.Car;
import com.revature.Sullivan.BTS.CarIDNumber;
import com.revature.Sullivan.BTS.CarIDNumberCounter;
import com.revature.Sullivan.DAO.CarDAOImplPG;
import com.revature.Sullivan.DAO.OffersImplPGDAO;
import com.revature.Sullivan.util.LoggingUtil;

public class LotImpl implements LotInt {
	
	private static CarDAOImplPG carDAO = new CarDAOImplPG();
	private static OffersImplPGDAO offersDAO = new OffersImplPGDAO();

	@Override
	public void viewCarLot() {
		
		LoggingUtil.trace("CarLotServiceImpl - viewCarLot(); - start");
		
		System.out.println("-- BBB: Let's Get These Sold! --");

		if (carDAO.getAllCars().size() == 0) {
			LoggingUtil.warn("CarLotServiceImpl - car lot is empty");
			System.out.println("BBB Lot is Empty!");
		} else {
		
			for (Car car : carDAO.getAllCars()) {
				System.out.println(car);
			}
		}

	}


	@Override
	public void addCar() {
	
		LoggingUtil.trace("CarLotServiceImpl - addCar(); - start");

		System.out.println("-- Add New BBB --");

		Car car = createCar();

		LoggingUtil.debug("car in add car method -> " + car);
		
		int newId = carDAO.insertCar(car);
		System.out.println(carDAO.getCarById(newId).getCarMakeAndModel() + " added!" + " Id Number: " + newId);

	}

	@Override
	public Car createCar() {
		
		LoggingUtil.trace("CarLotServiceImpl - createCar(); - start");

		String price = "";
		String carMakeAndModel = "";

		Scanner scanner = new Scanner(System.in);

		System.out.println("Beamer, Benz, or Bentley? ");
		carMakeAndModel = scanner.nextLine();

		System.out.println("How Much is it Worth? ");
		price = scanner.nextLine();

		
		CarIDNumber carId = new CarIDNumber(1);
		
		CarIDNumberCounter.getCaridcounter().add(carId);

		Car newCar = new Car("dealer", price, carMakeAndModel, true);

		LoggingUtil.debug("New Car Created ->" + newCar);

		return newCar;

	}

	@Override
	public void removeCarMenu() {
		
		LoggingUtil.trace("CarLotServiceImpl - removeCarMenu(); - start");
		
		System.out.println("-- BBB Elimination --");

		boolean exitInput = false;
		String input = "";

		
		
		do {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter '1' to See the BBB List");
			System.out.println("Enter '2': To input the BBB Number you would like to remove");
			System.out.println("Enter '9': Exit");

			input = scanner.nextLine();

			if (input.equals("1")) {
				viewCarLot();
				
				input = "";

			} else if (input.equals("2")) {

				if (carDAO.getAllCars().size() == 0) {
					System.out.println("Unable to Remove Car: BBB Lot is Empty");
				} else {

					removeCar(getCarId());
					input = "";
				}

			} else if (input.equals("9")) {
				exitInput = true;
			}

		} while (!exitInput);

	}

	@Override
	public Integer getCarId() {
		
		LoggingUtil.trace("CarLotServiceImpl - getCarId(); - start");

		Integer carID;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter BBB IDNumber:");
		while (!scanner.hasNextInt()) {
			System.out.println("Please Enter a Valid Number.");
			scanner.next();
		}
		carID = scanner.nextInt();
		scanner.nextLine();

		return carID;
	}

	@Override
	public void removeCar(Integer carId) {
		LoggingUtil.trace("CarLotServiceImpl - removeCar(); - start");

		Boolean carRemoveCheck = false;

		for (int i = 0; i < carDAO.getAllCars().size(); i++) {

			if (carDAO.getAllCars().get(i).getCarID() == carId) {

				carDAO.updateCarOnRemoval(carDAO.getCarById(carId));
		
				offersDAO.updateOfferOnCarRemoval(carId);

				carRemoveCheck = true;

			}
		}

		if (!carRemoveCheck) {
			System.out.println("BBB ID Not Found");
		}

	}


}
