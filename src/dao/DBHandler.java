package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Branch;
import classes.Employee;
import classes.Guest;
import classes.Host;
import classes.Payment;
import classes.Pricing;
import classes.Property;
import classes.Review;
import classes.rentalAgreement;

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
	
	//guest functions
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
	
	public Guest getGuest(int ID) {
		Guest guest = new Guest();
		try {
			sql = "select * from Project.guest where guestid = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				guest.setGuestID(resultSet.getInt(1));
				guest.setPassword(resultSet.getString(2));
				guest.setAddress(resultSet.getString(3));
				guest.setfName(resultSet.getString(4));
				guest.setlName(resultSet.getString(5));
				guest.setEmailAddress(resultSet.getString(6));
				guest.setPhoneNum(resultSet.getInt(7));
			}
			return guest;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return guest;
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
	
	//host functions
	public void inserteHost(Host host) {
		try {
			sql = "insert into Project.host values (?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, host.getHostID());
			preparedStatement.setString(2, host.getPassword());
			preparedStatement.setInt(3, host.getHouseNum());
			preparedStatement.setString(4, host.getStreet());
			preparedStatement.setString(5, host.getCity());
			preparedStatement.setString(6, host.getProvince());
			preparedStatement.setString(7, host.getHostFN());
			preparedStatement.setString(8, host.getHostLN());
			preparedStatement.setString(9, host.getEmailAddress());
			preparedStatement.setInt(10, host.getPhoneNum());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean findHost(int ID) {
		try {
			sql = "select * from Project.host where hostid = ?";
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
	
	public Host getHost(int ID) {
		Host host = new Host();
		try {
			sql = "select * from Project.host where hostid = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				host.setHostID(resultSet.getInt(1));
				host.setPassword(resultSet.getString(2));
				host.setHouseNum(resultSet.getInt(3));
				host.setStreet(resultSet.getString(4));
				host.setCity(resultSet.getString(5));
				host.setProvince(resultSet.getString(6));
				host.setHostFN(resultSet.getString(7));
				host.setHostLN(resultSet.getString(8));
				host.setEmailAddress(resultSet.getString(9));
				host.setPhoneNum(resultSet.getInt(10));
			}
			return host;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return host;
		}
	}
	
	public ArrayList<Property> getOwnProperties(int ID){
		ArrayList<Property> resultArrayList = new ArrayList<Property>();
		try {
			sql = "select * from Project.property where ownerid = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, ID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Property property = new Property();
				property.setPropertyID(resultSet.getInt(1));
				property.setOwnerID(resultSet.getInt(2));
				property.setHouseNum(resultSet.getInt(3));
				property.setStreet(resultSet.getString(4));
				property.setCity(resultSet.getString(5));
				property.setProvince(resultSet.getString(6));
				property.setCountry(resultSet.getString(7));
				property.setRoomType(resultSet.getString(8));
				property.setPrice(resultSet.getFloat(9));
				property.setAvailableDate(resultSet.getDate(10));
				property.setPropertyType(resultSet.getString(11));
				property.setPropertyClass(resultSet.getString(12));
				property.setNumGuest(resultSet.getInt(13));
				property.setAmenities(resultSet.getString(14));
				property.setRules(resultSet.getString(15));
				resultArrayList.add(property);
			}
			return resultArrayList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return resultArrayList;
		}
	}
	
	public ArrayList<Host> getAllHost() {
		ArrayList<Host> result = new ArrayList<Host>();
		try {
			statement = db.createStatement();
			sql = "select * from Project.host";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Host host = new Host();
				host.setHostID(resultSet.getInt(1));
				host.setPassword(resultSet.getString(2));
				host.setHouseNum(resultSet.getInt(3));
				host.setStreet(resultSet.getString(4));
				host.setCity(resultSet.getString(5));
				host.setProvince(resultSet.getString(6));
				host.setHostFN(resultSet.getString(7));
				host.setHostLN(resultSet.getString(8));
				host.setEmailAddress(resultSet.getString(9));
				host.setPhoneNum(resultSet.getInt(10));
				result.add(host);
			}
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}
	
	public void updateHostInt(int id, String column, int content) {
		try {
			sql = "update Project.host set " + column + " = " + "\'" + content + "\'" +" where hostid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateHostString(int id, String column, String content) {
		try {
			sql = "update Project.host set " + column + " = " + "\'" + content + "\'" +" where hostid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removeHost(int id) {
		try {
			sql = "delete from Project.host where hostid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//employee functions
	public void inserteEmplloyee(Employee employee) {
		try {
			sql = "insert into Project.employee values (?,?,?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getEmployeeID());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(3, employee.getfName());
			preparedStatement.setString(4, employee.getlName());
			preparedStatement.setFloat(5, employee.getSalary());
			preparedStatement.setString(6, employee.getPosition());
			preparedStatement.setInt(7, employee.getBranchID());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void inserteEmplloyeeFirst(Employee employee) {
		try {
			sql = "insert into Project.employee (employeeid, password, fname, lname, salary, position) values (?,?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getEmployeeID());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(3, employee.getfName());
			preparedStatement.setString(4, employee.getlName());
			preparedStatement.setFloat(5, employee.getSalary());
			preparedStatement.setString(6, employee.getPosition());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean findEmployee(int ID) {
		try {
			sql = "select * from Project.employee where employeeid = ?";
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
	
	public Employee getEmployee(int ID) {
		Employee employee = new Employee();
		try {
			sql = "select * from Project.employee where employeeid = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee.setEmployeeID(resultSet.getInt(1));
				employee.setPassword(resultSet.getString(2));
				employee.setfName(resultSet.getString(3));
				employee.setlName(resultSet.getString(4));
				employee.setSalary(resultSet.getFloat(5));
				employee.setPosition(resultSet.getString(6));
				employee.setBranchID(resultSet.getInt(7));
			}
			return employee;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return employee;
		}
	}
	
	public ArrayList<Employee> getAllEmployee() {
		ArrayList<Employee> result = new ArrayList<Employee>();
		try {
			statement = db.createStatement();
			sql = "select * from Project.employee";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeID(resultSet.getInt(1));
				employee.setPassword(resultSet.getString(2));
				employee.setfName(resultSet.getString(3));
				employee.setlName(resultSet.getString(4));
				employee.setSalary(resultSet.getFloat(5));
				employee.setPosition(resultSet.getString(6));
				employee.setBranchID(resultSet.getInt(7));
				result.add(employee);
			}
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}
	
	public void updateEmployeeInt(int id, String column, int content) {
		try {
			sql = "update Project.employee set " + column + " = " + "\'" + content + "\'" +" where employeeid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateEmployeeString(int id, String column, String content) {
		try {
			sql = "update Project.employee set " + column + " = " + "\'" + content + "\'" +" where employeeid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removeEmployee(int id) {
		try {
			sql = "delete from Project.employee where employeeid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//branch functions
	public void inserteBranch(Branch branch) {
		try {
			sql = "insert into Project.branch values (?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, branch.getBranchID());
			preparedStatement.setInt(2, branch.getBranchMgr());
			preparedStatement.setString(3, branch.getCountry());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void inserteBranchFirst(Branch branch) {
		try {
			sql = "insert into Project.branch (branchid, country) values (?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, branch.getBranchID());
			preparedStatement.setString(2, branch.getCountry());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean findBranch(int ID) {
		try {
			sql = "select * from Project.branch where branchid = ?";
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
	
	public ArrayList<Branch> getAllBranch() {
		ArrayList<Branch> result = new ArrayList<Branch>();
		try {
			statement = db.createStatement();
			sql = "select * from Project.branch";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Branch branch = new Branch();
				branch.setBranchID(resultSet.getInt(1));
				branch.setBranchMgr(resultSet.getInt(2));
				branch.setCountry(resultSet.getString(3));
				result.add(branch);
			}
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}
	
	public void updateBranchInt(int id, String column, int content) {
		try {
			sql = "update Project.branch set " + column + " = " + "\'" + content + "\'" +" where branchid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateBranchString(int id, String column, String content) {
		try {
			sql = "update Project.branch set " + column + " = " + "\'" + content + "\'" +" where branchid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removeBranch(int id) {
		try {
			sql = "delete from Project.branch where branchid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//agreement functions
	public void inserteRA(rentalAgreement rentalAgreement) {
		try {
			sql = "insert into Project.rentalAgreement values (?,?,?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, rentalAgreement.getAgreementID());
			preparedStatement.setInt(2, rentalAgreement.getHostID());
			preparedStatement.setInt(3, rentalAgreement.getGuestID());
			preparedStatement.setInt(4, rentalAgreement.getPropertyID());
			preparedStatement.setDate(5, rentalAgreement.getStartDate());
			preparedStatement.setDate(6, rentalAgreement.getEndDate());
			preparedStatement.setString(7, rentalAgreement.getSigning());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean findRA(int ID) {
		try {
			sql = "select * from Project.rentalagreement where agreementid = ?";
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
	
	public ArrayList<rentalAgreement> getAllRA() {
		ArrayList<rentalAgreement> result = new ArrayList<rentalAgreement>();
		try {
			statement = db.createStatement();
			sql = "select * from Project.rentalagreement";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				rentalAgreement rentalAgreement = new rentalAgreement();
				rentalAgreement.setAgreementID(resultSet.getInt(1));
				rentalAgreement.setHostID(resultSet.getInt(2));
				rentalAgreement.setGuestID(resultSet.getInt(3));
				rentalAgreement.setPropertyID(resultSet.getInt(4));
				rentalAgreement.setStartDate(resultSet.getDate(5));
				rentalAgreement.setEndDate(resultSet.getDate(6));
				rentalAgreement.setSigning(resultSet.getString(7));
				result.add(rentalAgreement);
			}
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}
	
	public void updateRAInt(int id, String column, int content) {
		try {
			sql = "update Project.rentalAgreement set " + column + " = " + "\'" + content + "\'" +" where agreementid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateRAString(int id, String column, String content) {
		try {
			sql = "update Project.rentalAgreement set " + column + " = " + "\'" + content + "\'" +" where agreementid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removeRA(int id) {
		try {
			sql = "delete from Project.rentalAgreement where agreementid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//property functions
	public void inserteProperty(Property property) {
		try {
			sql = "insert into Project.property values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, property.getPropertyID());
			preparedStatement.setInt(2, property.getOwnerID());
			preparedStatement.setInt(3, property.getHouseNum());
			preparedStatement.setString(4, property.getStreet());
			preparedStatement.setString(5, property.getCity());
			preparedStatement.setString(6, property.getProvince());
			preparedStatement.setString(7, property.getCountry());
			preparedStatement.setString(8, property.getRoomType());
			preparedStatement.setFloat(9, property.getPrice());
			preparedStatement.setDate(10, property.getAvailableDate());
			preparedStatement.setString(11, property.getPropertyType());
			preparedStatement.setString(12, property.getPropertyClass());
			preparedStatement.setInt(13, property.getNumGuest());
			preparedStatement.setString(14, property.getAmenities());
			preparedStatement.setString(15, property.getRules());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean findProperty(int ID) {
		try {
			sql = "select * from Project.property where propertyID = ?";
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
	
	public ArrayList<Property> getAllProperty() {
		ArrayList<Property> result = new ArrayList<Property>();
		try {
			statement = db.createStatement();
			sql = "select * from Project.property";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Property property = new Property();
				property.setPropertyID(resultSet.getInt(1));
				property.setOwnerID(resultSet.getInt(2));
				property.setHouseNum(resultSet.getInt(3));
				property.setStreet(resultSet.getString(4));
				property.setCity(resultSet.getString(5));
				property.setProvince(resultSet.getString(6));
				property.setCountry(resultSet.getString(7));
				property.setRoomType(resultSet.getString(8));
				property.setPrice(resultSet.getFloat(9));
				property.setAvailableDate(resultSet.getDate(10));
				property.setPropertyType(resultSet.getString(11));
				property.setPropertyClass(resultSet.getString(12));
				property.setNumGuest(resultSet.getInt(13));
				property.setAmenities(resultSet.getString(14));
				property.setRules(resultSet.getString(15));
				result.add(property);
			}
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}
	
	public void updateAvailableDate(int id, Date availableDate) {
		try {
			sql = "update Project.property set availabledate = " + "\'" + availableDate + "\'" +" where propertyid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updatePropertyInt(int id, String column, int content) {
		try {
			sql = "update Project.property set " + column + " = " + "\'" + content + "\'" +" where propertyid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updatePropertyString(int id, String column, String content) {
		try {
			sql = "update Project.property set " + column + " = " + "\'" + content + "\'" +" where propertyid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removeProperty(int id) {
		try {
			sql = "delete from Project.property where propertyid = " + id;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//pricing functions
	public void insertePricing(Pricing pricing) {
		try {
			sql = "insert into Project.pricing values (?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, pricing.getPropertyClass());
			preparedStatement.setFloat(2, pricing.getPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean findPricing(String propertyClass) {
		try {
			sql = "select * from Project.pricing where class = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, propertyClass);
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
	
	public ArrayList<Pricing> getAllPricing() {
		ArrayList<Pricing> result = new ArrayList<Pricing>();
		try {
			statement = db.createStatement();
			sql = "select * from Project.pricing";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Pricing pricing = new Pricing();
				pricing.setPropertyClass(resultSet.getString(1));
				pricing.setPrice(resultSet.getFloat(2));
				result.add(pricing);
			}
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}
	
	public void updatePricingInt(String propertyClass, String column, int content) {
		try {
			sql = "update Project.pricing set " + column + " = " + "\'" + content + "\'" +" where class = " + propertyClass;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updatePricingString(String propertyClass, String column, String content) {
		try {
			sql = "update Project.pricing set " + column + " = " + "\'" + content + "\'" +" where class = " + propertyClass;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removePricing(String propertyClass) {
		try {
			sql = "delete from Project.pricing where class = " + propertyClass;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//payment functions
	public void insertePayment(Payment payment) {
		try {
			sql = "insert into Project.payment values (?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, payment.getPaymentID());
			preparedStatement.setInt(2, payment.getHostID());
			preparedStatement.setString(3, payment.getPaymentType());
			preparedStatement.setFloat(4, payment.getAmount());
			preparedStatement.setString(5, payment.getStatus());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean findPayment(int ID) {
		try {
			sql = "select * from Project.payment where paymentid = ?";
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
	
	public String checkPaymentStatus(int ID) {
		String result = "";
		try {
			sql = "select status from project.payment where paymentid = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, ID);
			while (resultSet.next()) {
				result = resultSet.getString(1);
			}
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}
	
	public ArrayList<Payment> getAllPayment() {
		ArrayList<Payment> result = new ArrayList<Payment>();
		try {
			statement = db.createStatement();
			sql = "select * from Project.payment";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Payment payment = new Payment();
				payment.setPaymentID(resultSet.getInt(1));
				payment.setHostID(resultSet.getInt(2));
				payment.setPaymentType(resultSet.getString(3));
				payment.setAmount(resultSet.getFloat(4));
				payment.setStatus(resultSet.getString(5));
				result.add(payment);
			}
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}
	
	public void updatePaymentInt(int ID, String column, int content) {
		try {
			sql = "update Project.payment set " + column + " = " + "\'" + content + "\'" +" where paymentid = " + ID;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updatePaymentString(int ID, String column, String content) {
		try {
			sql = "update Project.payment set " + column + " = " + "\'" + content + "\'" +" where paymentid = " + ID;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removePayment(int ID) {
		try {
			sql = "delete from Project.payment where paymentid = " + ID;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//review functions
	public void inserteReview(Review review) {
		try {
			sql = "insert into Project.review values (?,?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, review.getReviewID());
			preparedStatement.setInt(2, review.getPropertyID());
			preparedStatement.setInt(3, review.getRating());
			preparedStatement.setString(4, review.getCommunication());
			preparedStatement.setString(5, review.getCleanliness());
			preparedStatement.setString(6, review.getValue());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean findReview(int ID) {
		try {
			sql = "select * from Project.review where reviewid = ?";
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
	
	public ArrayList<Review> getReviewByID(int ID){
		ArrayList<Review> result = new ArrayList<Review>();
		try {
			statement = db.createStatement();
			sql = "select * from Project.review where id = " + ID;
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Review review = new Review();
				review.setReviewID(resultSet.getInt(1));
				review.setPropertyID(resultSet.getInt(2));
				review.setRating(resultSet.getInt(3));
				review.setCommunication(resultSet.getString(4));
				review.setCleanliness(resultSet.getString(5));
				review.setValue(resultSet.getString(6));
				result.add(review);
			}
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}
	
	public ArrayList<Review> getAllReview() {
		ArrayList<Review> result = new ArrayList<Review>();
		try {
			statement = db.createStatement();
			sql = "select * from Project.review";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Review review = new Review();
				review.setReviewID(resultSet.getInt(1));
				review.setPropertyID(resultSet.getInt(2));
				review.setRating(resultSet.getInt(3));
				review.setCommunication(resultSet.getString(4));
				review.setCleanliness(resultSet.getString(5));
				review.setValue(resultSet.getString(6));
				result.add(review);
			}
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}
	
	public void updateReviewInt(int ID, String column, int content) {
		try {
			sql = "update Project.review set " + column + " = " + "\'" + content + "\'" +" where reviewid = " + ID;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateReviewString(int ID, String column, String content) {
		try {
			sql = "update Project.review set " + column + " = " + "\'" + content + "\'" +" where reviewid = " + ID;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removeReview(int ID) {
		try {
			sql = "delete from Project.review where reviewid = " + ID;
			statement = db.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
