package com.bridgelabz.connectionofjdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayroll extends BaseClass {

	public void retrieveEmployeePayrollData() throws SQLException {
		connection = setUpDatabase();
		Statement statement = connection.createStatement();
		String query = "select * from employeepayroll";
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String gender = resultSet.getString(3);
			double salary = resultSet.getDouble(4);
			String date_info = resultSet.getString(5);
			System.out.println(id + " " + name + " " + gender + " " + salary + " " + date_info);
		}

		System.out.println("Retrieve all the employee payroll data");
	}
	public void insertEmployeePayrollData() throws SQLException {
		connection = setUpDatabase();
		String insertQuery = "Insert into employeepayroll (name, gender,salary,date_info )values(?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, "Terrisa");
		preparedStatement.setString(2, "F");
		preparedStatement.setDouble(3, 25000000.00);
		preparedStatement.setString(4, "2020-05-01");
		preparedStatement.execute();

		System.out.println("Record added successfully");
	}
	public void updateEmployeePayrollData() throws SQLException {
		connection = setUpDatabase();
		String updateQuery = "update employeepayroll set salary = 3000000.00 WHERE name = 'Terrisa'";
		PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
		preparedStatement.executeUpdate();
		System.out.println("Record updated successfully");
	}

	public void updateWithPreparedStementEmployeePayrollData() throws SQLException {
		connection = setUpDatabase();
		String updateQuery = "update employeepayroll set salary = ? WHERE name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
		preparedStatement.setDouble(1, 3000000.00);
		preparedStatement.setString(2, "Terrisa");
		preparedStatement.executeUpdate();
		System.out.println("Record updated successfully");
	}
	public void deleteEmployeePayroll() throws SQLException {
		connection = setUpDatabase();
		String deleteQuery = "Delete from employeepayroll where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
		preparedStatement.setInt(1, 5);
		preparedStatement.executeUpdate();
		System.out.println("Record deleted successfully");
	}

}

