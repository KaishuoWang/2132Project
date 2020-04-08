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
<<<<<<< HEAD
	
		dbHandler.closeDB();
		
		System.out.println(4/2);
=======
		
		System.out.println(dbHandler.getPropertyStatement(123));
		
		dbHandler.closeDB();
>>>>>>> 659d6bf368ff27f33aecf3874f506b443b058105
	}
}
