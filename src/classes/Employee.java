package classes;

public class Employee {
	
	private int employeeID;
	private String fName;
	private String lName;
	private float salary;
	private String position;
	private int branchID;
	private String password;
	
	public Employee(int employeeID, String fName, String lName, String password) {
		this.employeeID = employeeID;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
	}
	
	public Employee(int employeeID, String fName, String lName, String password, int branchid) {
		this.employeeID = employeeID;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.branchID = branchid;
	}
	
	public Employee() {}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
}