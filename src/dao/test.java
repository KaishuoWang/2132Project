package dao;

public class test {
	public static void main(String[] args) {
		DBHandler dbHandler = new DBHandler();
		dbHandler.getAllGuest();
		dbHandler.closeDB();
	}
}
