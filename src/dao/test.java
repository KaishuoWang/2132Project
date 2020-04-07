package dao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import classes.Branch;
import classes.Employee;
import classes.Guest;
import classes.Host;
import classes.Property;

public class test {
	public static void main(String[] args) {
		DBHandler dbHandler = new DBHandler();
		
		
		
		dbHandler.closeDB();
		
		Date d = Date.valueOf("2020-01-03");
		
		System.out.println(d);
	}
}
