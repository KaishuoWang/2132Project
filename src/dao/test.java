package dao;

import java.util.ArrayList;

import classes.Branch;
import classes.Employee;
import classes.Guest;
import classes.Host;
import classes.Property;

public class test {
	public static void main(String[] args) {
		DBHandler dbHandler = new DBHandler();
		
		ArrayList<Property> resultArrayList = dbHandler.getOwnProperties(123);
		System.out.println(resultArrayList.get(0).getAvailableDate());
		
		dbHandler.closeDB();
	}
}
