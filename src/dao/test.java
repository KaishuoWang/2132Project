package dao;

import java.util.ArrayList;

import classes.Branch;
import classes.Employee;
import classes.Guest;
import classes.Host;

public class test {
	public static void main(String[] args) {
		DBHandler dbHandler = new DBHandler();
		Employee employee = new Employee(123, "K", "W", "123",123);
		Branch branch = new Branch(123, "China");
		//dbHandler.inserteBranchFirst(branch);
		
		dbHandler.inserteEmplloyee(employee);
		
		//System.out.println(dbHandler.findBranch(123));
		
		//ArrayList<Branch> result = dbHandler.getAllBranch();
		//System.out.println(result.get(0).getCountry());
		
		//dbHandler.updateBranchInt(123, "branchmgr", 123);
		
		//dbHandler.updateBranchString(123, "country", "Canada");
		
		//dbHandler.removeEmployee(123);
		
		dbHandler.closeDB();
	}
}
