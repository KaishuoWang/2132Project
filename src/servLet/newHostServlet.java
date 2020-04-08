package servLet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Employee;
import classes.Host;
import dao.DBHandler;

@WebServlet(urlPatterns = "/createNewHost")
public class newHostServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBHandler dbHandler = new DBHandler();
		
		String id = req.getParameter("id");
		int hostID = Integer.parseInt(id);
		String Fname = req.getParameter("Fname");
		String Lname = req.getParameter("Lname");
		String password = req.getParameter("password");
		String houseNum = req.getParameter("houseNum");
		String street = req.getParameter("street");
		String city = req.getParameter("city");
		String province = req.getParameter("province");
		String email = req.getParameter("email");
		String phoneNum = req.getParameter("phoneNum");
		if(dbHandler.findHost(hostID)) {
			resp.sendRedirect("newEmployeeFailed.html");
		}else {
			Host host = new Host(Fname, Lname, hostID, password);
			if(!houseNum.equals("")) {
				host.setHouseNum(Integer.parseInt(houseNum));
			}
			if(!street.equals("")) {
				host.setStreet(street);
			}
			if(!city.equals("")) {
				host.setCity(city);
			}
			if(!province.equals("")){
				host.setProvince(province);
			}
			if(!email.equals("")) {
				host.setEmailAddress(email);
			}
			if(!phoneNum.equals("")) {
				host.setPhoneNum(Integer.parseInt(phoneNum));
			}
			
			dbHandler.inserteHost(host);
			resp.sendRedirect("newAccountSuccess.html");
		}
		
		dbHandler.closeDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}