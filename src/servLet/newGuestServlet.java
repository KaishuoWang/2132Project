package servLet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Employee;
import classes.Guest;
import dao.DBHandler;

@WebServlet(urlPatterns = "/createNewGuest")
public class newGuestServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBHandler dbHandler = new DBHandler();
		
		String id = req.getParameter("id");
		int guestID = Integer.parseInt(id);
		String Fname = req.getParameter("Fname");
		String Lname = req.getParameter("Lname");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String emailAddress = req.getParameter("email");
		String phoneNumString = req.getParameter("phoneNUm");
		if(dbHandler.findGuest(guestID)) {
			resp.sendRedirect("newGuestFailed.html");
		}else {
			Guest guest = new Guest(guestID, Fname, Lname, password);
			if(!phoneNumString.equals("")) {
				guest.setPhoneNum(Integer.parseInt(phoneNumString));
			}
			if(!address.equals("")) {
				guest.setAddress(address);;
			}
			if(!emailAddress.equals("")) {
				guest.setEmailAddress(emailAddress);;
			}
			dbHandler.inserteGuest(guest);
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
