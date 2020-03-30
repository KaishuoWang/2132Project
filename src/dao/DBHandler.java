package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Guest;

public class DBHandler {
	private Connection db;
	private static String url = "jdbc:postgresql://web0.site.uottawa.ca:15432/kwang126";
	private static String userName = "kwang126";
	private static String password = "Wks20000109";
	private String sql;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	
	public DBHandler() {
		try {
			db = DriverManager.getConnection(url, userName, password);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void closeDB() {
		try {
			if (statement != null) {
				statement.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void inserteGuest(Guest guest) {
		try {
			sql = "insert into Project.guest values (?,?,?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, guest.getGuestID());
			preparedStatement.setString(2, guest.getPassword());
			preparedStatement.setString(3, guest.getAddress());
			preparedStatement.setString(4, guest.getfName());
			preparedStatement.setString(5, guest.getlName());
			preparedStatement.setString(6, guest.getEmailAddress());
			preparedStatement.setInt(7, guest.getPhoneNum());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean findGuest(int ID) {
		try {
			sql = "select * from Project.guest where guestid = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Guest> getAllGuest() {
		ArrayList<Guest> result = new ArrayList<Guest>();
		try {
			statement = db.createStatement();
			sql = "select * from Project.guest";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Guest guest = new Guest();
				guest.setGuestID(resultSet.getInt(1));
				guest.setPassword(resultSet.getString(2));
				guest.setAddress(resultSet.getString(3));
				guest.setfName(resultSet.getString(4));
				guest.setlName(resultSet.getString(5));
				guest.setEmailAddress(resultSet.getString(6));
				guest.setPhoneNum(resultSet.getInt(7));
				result.add(guest);
			}
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}
	
	public void updateGuestInt(int id, String column, int content) {
		try {
			sql = "update Project.guest set " + column + " = " + "\'" + content + "\'" +" where guestid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateGuestString(int id, String column, String content) {
		try {
			sql = "update Project.guest set " + column + " = " + "\'" + content + "\'" +" where guestid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removeGuest(int id) {
		try {
			sql = "delete from Project.guest where guestid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
