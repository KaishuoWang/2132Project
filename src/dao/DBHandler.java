package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
	private Connection db;
	private static String url = "jdbc:postgresql://web0.site.uottawa.ca:15432/kwang126";
	private static String userName = "kwang126";
	private static String password = "Wks20000109";
	
	public DBHandler() {
		try {
			db = DriverManager.getConnection(url, userName, password);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}
}
