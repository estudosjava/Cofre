package br.com.cofrinho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {

			String STR_DRIVER = "com.mysql.jdbc.Driver";
			String DATABASE = "cofrinho";
			String IP = "chapolin";
			String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE;
			String USER = "cofrinho";
			String PASSWORD = "1a2b3c";

			Connection con = null;

			try {
				Class.forName(STR_DRIVER);
				con = DriverManager.getConnection(STR_CON, USER, PASSWORD);

			} catch (ClassNotFoundException e) {
				System.out.println("CLASS ERROR: " + e);

			} catch (SQLException e) {
				System.out.println("SQL ERROR: " + e);
			}
			return DriverManager.getConnection(STR_CON, USER, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
