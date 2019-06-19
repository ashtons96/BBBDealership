package com.revature.Sullivan.services;

import java.util.Scanner;

import com.revature.Sullivan.BTS.Car;
import com.revature.Sullivan.BTS.Customers;
import com.revature.Sullivan.DAO.CarDAOImplPG;
import com.revature.Sullivan.DAO.CustomersImplPGDAO;
import com.revature.Sullivan.DAO.OffersImplPGDAO;
import com.revature.Sullivan.util.LoggingUtil;

public class EmpServiceImpl implements EmpServiceInt {

	private static CarDAOImplPG carDAO = new CarDAOImplPG();
	private static OffersImplPGDAO offersDAO = new OffersImplPGDAO();
	private static CustomersImplPGDAO customerDAO = new CustomersImplPGDAO();

	@Override
	public void acceptOffer() {
	
		LoggingUtil.trace("EmployeeServiceImpl - acceptOffer() - start");
		
		System.out.println("-- Accept Offer Screen --");

		Scanner scanner = new Scanner(System.in);
		
		Integer acceptId;
		boolean accepted = false;

		System.out.println("Enter Offer ID to Accept into the BBB Family ");
		while (!scanner.hasNextInt()) {
			System.out.println("Please Enter a Valid Number.");
			scanner.next();
		}
		acceptId = scanner.nextInt();
		scanner.nextLine();

		for (int o = 0; o < offersDAO.getAllOffers().size(); o++) {

			if (offersDAO.getAllOffers().get(o).getOfferID() == acceptId) {
				
				LoggingUtil.trace("acceptOffer(); - found matching ID");

				accepted = true;

				Car offerCar = offersDAO.getAllOffers().get(o).getOfferCar();
				Customers buyer = offersDAO.getAllOffers().get(o).getOfferCust();

				buyer.getCarsOwned().add(offerCar);

				buyer.setBalance(buyer.getBalance() + offersDAO.getAllOffers().get(o).getPrice());

				offerCar.setPurchasedPrice(offersDAO.getAllOffers().get(o).getPrice().toString());

				for (int p = 0; p < buyer.getPendingOffers().size(); p++) {
					if (buyer.getPendingOffers().get(p).getOfferID() == acceptId) {
						buyer.getPendingOffers().remove(p);
					}
				}

				if (!buyer.isMakingPayments()) {
					buyer.setMakingPayments(true);
				}
				for (int i = offersDAO.getAllOffers().size() - 1; i >= 0; i--) {
					if (offersDAO.getAllOffers().get(i).getOfferCar().getCarID() == offerCar.getCarID()) {

						offersDAO.updateOffer(offersDAO.getAllOffers().get(i), 1);

					}
				}
				offerCar.setForSale(false);
				offerCar.setCarOfferList(null);
				offerCar.setOwnerUsername(buyer.getUsername());

				
				
				
				WebImpl w = new WebImpl();
				w.calculateMonthlyPayment(buyer);

				carDAO.acceptOfferUpdate(offerCar, buyer);
				offersDAO.acceptOfferUpdate(acceptId, buyer);
				customerDAO.acceptOfferUpdate(buyer);

			}

		}

		if (!accepted) {
			System.out.println("ID Not Found. Please Try Again.");
		}

	}

	@Override
	public void rejectOffer() {
		LoggingUtil.trace("EmployeeServiceImpl - rejectOffer() - start");
		System.out.println("-- That's Not BBB Rejection Screen --");

		Scanner scanner = new Scanner(System.in);
		Integer rejectId;
		boolean rejected = false;

		System.out.println("Enter BBB Offer ID to reject:");
		while (!scanner.hasNextInt()) {
			System.out.println("Please Enter a Valid Number.");
			scanner.next();
		}
		rejectId = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < offersDAO.getAllOffers().size(); i++) {
			if (offersDAO.getAllOffers().get(i).getOfferID() == rejectId) {

				offersDAO.updateRejectOffer(rejectId);
				rejected = true;

			}
		}

		if (!rejected) {
			System.out.println("ID Not Found. Please Try Again.");
		}

	}

	@Override
	public void offerDecisionMenu() {
		LoggingUtil.trace("CarLotServiceImpl - addCar(); - start");

		System.out.println("-- Offer Decision Screen --");

		WebImpl w = new WebImpl();

		boolean exitInput = false;
		String input = "";

		do {
			LoggingUtil.trace("CarLotServiceImpl - do loop - start");

			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter '1': To See What BBB has to Offer");
			System.out.println("Enter '2': To ACCEPT a New Member into the BBB Family");
			System.out.println("Enter '3': To REJECT (That Offer Ain't BBB Material");
			System.out.println("Enter '9': Exit!");

			input = scanner.nextLine();

			if (input.equals("1")) {
				
				LoggingUtil.trace("do loop - accept/reject decision menu - calling viewCarOfferList();");
				
				w.viewCarOfferList();
				exitInput = false;
			} else if (input.equals("2")) {
				
				LoggingUtil.trace("do loop - accept/reject decision menu - calling acceptOffer();");
				
				acceptOffer();
				exitInput = false;
				
			} else if (input.equals("3")) {
				
				LoggingUtil.trace("do loop - accept/reject decision menu - calling rejectOffer();");
				
				rejectOffer();
				exitInput = false;
				
			} else if (input.equals("9")) {
				
				LoggingUtil.trace("do loop - accept/reject decision menu - exiting");
				
				exitInput = true;
			}

		} while (!exitInput);

	}


}
