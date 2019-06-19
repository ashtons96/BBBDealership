package com.revature.Sullivan.BTS;

public class Employees {
	private static final Employees employee = new Employees();

	public static Employees getEmployee() {
		return employee;
	}

	private final String USERNAME = "useremployee";
	private final String PASSWORD = "employeepassword";

	public String getUSERNAME() {
		return USERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	@Override
	public String toString() {
		return "Employee [USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + "]";
	}



}
