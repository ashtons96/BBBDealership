package com.revature.Sullivan.driver;

import java.sql.Connection;

import com.revature.Sullivan.screens.ScreenCust;
import com.revature.Sullivan.screens.ScreenEmp;
import com.revature.Sullivan.services.WebImpl;
import com.revature.Sullivan.util.LoggingUtil;
import com.revature.Sullivan.util.ConnectionFactory;
import java.sql.DriverManager;


public class BBBDriver {


Connection conn = ConnectionFactory.getConnection();



	public static void main(String[] args) {

		
		
		WebImpl w = new WebImpl();

		boolean keepGoing = true;

		do {
			LoggingUtil.trace("Do Loop in Main - Start");

			String screen = w.initialScreen();

			if (screen.equals("employee")) {
				LoggingUtil.trace("Do Loop in Main - if -> 'employee'");
				ScreenEmp e = new ScreenEmp();

				if (!e.display()) {
					LoggingUtil.trace("Do Loop in Main - saving files - employee");

					continue;
				}

			} else if (screen.equals("customer")) {
				LoggingUtil.trace("Do Loop in Main - if -> 'customer'");
				ScreenCust c = new ScreenCust();

				
				if (!c.display()) {
					LoggingUtil.trace("Do Loop in Main - saving files - employee");

					continue;
				}
			}

		} while (keepGoing);

	
  

}
}

