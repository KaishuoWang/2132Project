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
		if(!dbHandler.findProperty(Integer.parseInt(req.getParameter("paymentID")))){
			resp.sendRedirect("alreadyBooked.html");
		}else {
			resp.sendRedirect("payment.jsp");
			rentalAgreement rentalAgreement = new rentalAgreement(Integer.parseInt(req.getParameter("paymentID")),dbHandler.getPropertyHostid(Integer.parseInt(req.getParameter("propertyID"))),Integer.parseInt(req.getParameter("propertyID")),Integer.parseInt(req.getParameter("guestID")),Date.valueOf(req.getParameter("startDate")),Date.valueOf(req.getParameter("endDate")),req.getParameter("signing"));
			dbHandler.inserteRA(rentalAgreement);
		}
		dbHandler.closeDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}