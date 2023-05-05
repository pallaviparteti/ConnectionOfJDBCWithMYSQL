package com.bridgelabz.connectionofjdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class BaseClass {

	public static Connection connection;

	public static void main(String[] args) throws SQLException {

		listOfDrivers();
		setUpDatabase();
		EmployeePayroll employeePayroll = new EmployeePayroll();
		employeePayroll.retrieveEmployeePayrollData();
		employeePayroll.insertEmployeePayrollData();
		employeePayroll.updateEmployeePayrollData();
		employeePayroll.deleteEmployeePayroll();
		employeePayroll.findDataBetweenGivenDateRange();
		employeePayroll.sumOFGivenSalary();
		employeePayroll.minOFGivenSalary();
		employeePayroll.maxOFGivenSalary();
		employeePayroll.avrageOFGivenSalary();
		employeePayroll.countOFGivenSalary();
	}

	public static Connection setUpDatabase() {
		String jdbcURL = "jdbc:mysql://localhost:3306/student_details";
		String username = "root";
		String password = "@*piyux3R";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			throw new IllegalStateException("Cannot load the driver successfully" + e);
		}

		try {
			System.out.println("Databases connected to the database: " + jdbcURL);
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connection established successfully" + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void listOfDrivers() {
		Enumeration<Driver> enumeration = DriverManager.getDrivers();
		while (enumeration.hasMoreElements()) {
			Driver driver = (Driver) enumeration.nextElement();
			System.out.println("  " + driver.getClass().getName());
		}
	}

}



