package servLet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Payment;
import classes.Property;
import classes.rentalAgreement;
import dao.DBHandler;

@WebServlet(urlPatterns = "/finish")
public class paymentServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBHandler dbHandler = new DBHandler();
		req.getRequestDispatcher("/payment.jsp").forward(req, resp);
		rentalAgreement rentalAgreement = new rentalAgreement(Integer.parseInt(req.getParameter("paymentID")),Integer.parseInt(req.getParameter("hostID")),Integer.parseInt(req.getParameter("propertyID")),Integer.parseInt(req.getParameter("guestID")),Date.valueOf(req.getParameter("startDate")),Date.valueOf(req.getParameter("endDate")),req.getParameter("signing"));
		if(!req.getParameter("paymentID").equals("")) {
			rentalAgreement.setAgreementID(0);
		}
		if(!req.getParameter("hostID").equals("")) {
			rentalAgreement.setHostID(0);
		}
		if(!req.getParameter("propertyID").equals("")) {
			rentalAgreement.setPropertyID(0);
		}
		if(!req.getParameter("guestID").equals("")) {
			rentalAgreement.setGuestID(0);
		}
		if(!req.getParameter("startDate").equals("")) {
			rentalAgreement.setStartDate(null);
		}
		if(!req.getParameter("endDate").equals("")) {
			rentalAgreement.setEndDate(null);
		}
		if(!req.getParameter("signing").equals("")) {
			rentalAgreement.setSigning(null);
		}
		dbHandler.inserteRA(rentalAgreement);
		dbHandler.closeDB();
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
