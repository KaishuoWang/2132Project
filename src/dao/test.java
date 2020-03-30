package dao;

import java.util.ArrayList;

import classes.Guest;

public class test {
	public static void main(String[] args) {
		DBHandler dbHandler = new DBHandler();
		Guest guest = new Guest(123, "W", "K", "1123");
		
		//dbHandler.inserteGuest(guest);
		
		boolean result = dbHandler.findGuest(123);
		System.out.println(result);
		dbHandler.closeDB();
	}
}
