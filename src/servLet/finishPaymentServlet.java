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
import dao.DBHandler;

@WebServlet(urlPatterns = "/finishPayment")
public class finishPaymentServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBHandler dbHandler = new DBHandler();
		req.getRequestDispatcher("/lastPage.jsp").forward(req, resp);
		if(!dbHandler.findProperty(Integer.parseInt(req.getParameter("id")))){
			resp.sendRedirect("alreadyBooked.html");
		}else {
			resp.sendRedirect("paymentPR.html");
			Payment payment = new Payment(Integer.parseInt(req.getParameter("paymentID")),Integer.parseInt(req.getParameter("hostID")),req.getParameter("paymentType"),Float.parseFloat(req.getParameter("amount")), req.getParameter("status"));
			if(req.getParameter("paymentID").equals("")) {
				payment.setPaymentID(0);
				}
			if(req.getParameter("hostID").equals("")) {
				payment.setHostID(0);
				}
			if(req.getParameter("propertyID").equals("")) {
				payment.setPaymentType("");
				}
			if(req.getParameter("amount").equals("")) {
				payment.setAmount(0);
				}
			if(req.getParameter("status").equals("")) {
				payment.setStatus(null);
				}
			dbHandler.insertePayment(payment);
		}
		Payment payment = new Payment(Integer.parseInt(req.getParameter("paymentID")),Integer.parseInt(req.getParameter("hostID")),req.getParameter("paymentType"),Float.parseFloat(req.getParameter("amount")), req.getParameter("status"));
		if(req.getParameter("paymentID").equals("")) {
			payment.setPaymentID(0);
		}
		if(req.getParameter("hostID").equals("")) {
			payment.setHostID(0);
		}
		if(req.getParameter("propertyID").equals("")) {
			payment.setPaymentType("");
		}
		if(req.getParameter("amount").equals("")) {
			payment.setAmount(0);
		}
		if(req.getParameter("status").equals("")) {
			payment.setStatus(null);
		}
		dbHandler.insertePayment(payment);
		req.getRequestDispatcher("/lastPage.jsp").forward(req, resp);
		dbHandler.closeDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}