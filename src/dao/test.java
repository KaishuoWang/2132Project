package dao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import classes.Branch;
import classes.Employee;
import classes.Guest;
import classes.Host;
import classes.Payment;
import classes.Property;

public class test {
	public static void main(String[] args) {
		DBHandler dbHandler = new DBHandler();
	
		System.out.println(dbHandler.getPropertyHostid(123));
		
		dbHandler.closeDB();
	}
}
