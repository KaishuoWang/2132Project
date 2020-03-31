package dao;

import java.sql.Connection;
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
}
