package com.myfirstmaven.test.HelloMaven;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	public void WriteToDatabase(String name, String email) {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=MyDatabase;user=andrei;password=123test";

		try (Connection con = DriverManager.getConnection(connectionUrl); 
				Statement stmt = con.createStatement();) {
			
			String SQL = "INSERT INTO person (name, email) VALUES ('" + name + "', '" + email + "');";
			stmt.execute(SQL);

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
