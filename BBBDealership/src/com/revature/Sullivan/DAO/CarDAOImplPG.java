package com.revature.Sullivan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Sullivan.BTS.Car;
import com.revature.Sullivan.BTS.Customers;
import com.revature.Sullivan.util.ConnectionFactory;
import com.revature.Sullivan.util.LoggingUtil;

public class CarDAOImplPG implements CarDAOSQL {
private static Connection conn = ConnectionFactory.getConnection();
	
	private static OffersImplPGDAO offersDAO = new OffersImplPGDAO();

	@Override
	public int insertCar(Car car) {
		
		LoggingUtil.debug("In insertCar DAO");
		
		String s = "insert into car(type, price) " + "values(?, ?);";

		PreparedStatement ps;
		int newId = 0;

		try {

			ps = conn.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, car.getCarMakeAndModel());
			ps.setString(2, car.getPrice());
			int numberOfRows = ps.executeUpdate();

			
			ResultSet rs = ps.getGeneratedKeys();
			
			
			
			if (rs.next()) {
				LoggingUtil.debug("generated primary key/id was grabbed for car");
				newId = rs.getInt(1);
			}
			
			LoggingUtil.debug(numberOfRows + " number of rows affected - insertCar");

		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
		}
		
		return newId;

	}

	// only happens when car is bought
	@Override
	public void updateCarOnAcceptOffer(Car car, Customers customer) {
		String s = "update car "
				+ "set customer_id = ?, owner_username = ?, price = ?, type = ?, for_sale = ?, purchased_price = ? "
				+ "where car_id = ?;";

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(s);
			ps.setInt(1, customer.getCustomerID());
			ps.setString(2, customer.getUsername());
			ps.setString(3, car.getPrice());
			ps.setString(4, car.getCarMakeAndModel());
			ps.setBoolean(5, car.getForSale());
			ps.setString(6, car.getPurchasedPrice());
			ps.setInt(7, car.getCarID());
			int numberOfRows = ps.executeUpdate();

			LoggingUtil.debug(numberOfRows + " number of rows affected - updateCar");

		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
		}

	}
	
	@Override
	public void updateCarOnRemoval(Car car) {
		String s = "update car " + " car_available = ? " + " car_id = ?;";

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(s);
			ps.setBoolean(1, false); //removal of car from list == false in db
			ps.setInt(2, car.getCarID());
			int numberOfRows = ps.executeUpdate();

			LoggingUtil.debug(numberOfRows + " number of rows affected - updateCar");

		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
		}
	}

	@Override
	public List<Car> getAllCars() {
		List<Car> carList = new ArrayList<>();

		String s = "select * from car where for_sale = true;";

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(s);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				Car car = new Car(rs.getString("owner_username"), rs.getString("price"), rs.getString("type"),
						rs.getBoolean("for_sale"), rs.getInt("car_id"));

				car.setPurchasedPrice(rs.getString("purchased_price"));

				
				car.setCarOfferList(offersDAO.getOffersByCarId(car.getCarID()));
				
				carList.add(car);
			}

		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
		}

		return carList;
	}

	@Override
	public List<Car> getCarsByCustomerId(int id) {
		List<Car> customerCarList = new ArrayList<>();

		String s = "select * from car " + 
				"where customer_id = ?;";

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(s);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Car car = new Car(rs.getString("owner_username"), rs.getString("price"), rs.getString("type"),
						rs.getBoolean("for_sale"), rs.getInt("car_id"));

				car.setPurchasedPrice(rs.getString("purchased_price"));

				car.setCarOfferList(offersDAO.getOffersByCarId(car.getCarID()));

				customerCarList.add(car);
			}

		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
		}

		return customerCarList;
	}
	
	@Override
	public Car getCarById(int id) {
		Car car = null;

		String s = "select * from car " + "where car_id = ? and for_sale = true;";

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(s);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				car = new Car(rs.getString("owner_username"), rs.getString("price"), rs.getString("type"),
						rs.getBoolean("for_sale"), rs.getInt("car_id"));

				car.setPurchasedPrice(rs.getString("purchased_price"));

			}

		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
		}

		return car;
	}
	

	

} 
