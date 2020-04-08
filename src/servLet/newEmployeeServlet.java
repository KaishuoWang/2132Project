package servLet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Employee;
import dao.DBHandler;

@WebServlet(urlPatterns = "/createNewEmployee")
public class newEmployeeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBHandler dbHandler = new DBHandler();
		String id = req.getParameter("id");
		int employeeID = Integer.parseInt(id);
		String Fname = req.getParameter("Fname");
		String Lname = req.getParameter("Lname");
		String password = req.getParameter("password");
		String salary = req.getParameter("salary");
		String position = req.getParameter("position");
		String branch = req.getParameter("branch");
		
		if(branch != null) {
			int branchID = Integer.parseInt(branch);
			if(dbHandler.findBranch(branchID) == false || dbHandler.findEmployee(employeeID)) {
				resp.sendRedirect("newPropertyFailed.html");
			}else {
				Employee employee = new Employee(employeeID, Fname, Lname, password);
				employee.setBranchID(branchID);
				employee.setPosition(position);
				if(salary != null) {
					float salaryF = Float.parseFloat(salary);
					employee.setSalary(salaryF);
				}
			}
		}else {
			if(dbHandler.findEmployee(employeeID)) {
				resp.sendRedirect("newPropertyFailed.html");
			}else {
				Employee employee = new Employee(employeeID, Fname, Lname, password);
				employee.setPosition(position);
				if(salary != null) {
					float salaryF = Float.parseFloat(salary);
					employee.setSalary(salaryF);
				}
			}
		}
		
		dbHandler.closeDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
