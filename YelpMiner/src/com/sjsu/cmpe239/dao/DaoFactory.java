package com.sjsu.cmpe239.dao;

// Testing 
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * @author ManjulaKollipara
 *
 */
public class DaoFactory{

	public Connection getJdbcConnection()
	{
		System.out.println("DaoFactory: Database connection module");

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("DaoFactory: Mysql Driver not found");
			e.printStackTrace();
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cmpe239","root", "");

		} catch (SQLException e) {
			System.out.println("DaoFactory:Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {

			System.out.println("DaoFactory:connection successful..!");

		} else {

			System.out.println("DaoFactory:Failed to make connection!");
		}
		
		return connection;
	}
}