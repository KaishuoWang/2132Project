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
<<<<<<< HEAD
		req.getRequestDispatcher("/lastPage.jsp").forward(req, resp);
=======
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
=======
>>>>>>> 5ad1e92158730f17c1fcf1906a345566a48ed95c
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
<<<<<<< HEAD
		
=======
		req.getRequestDispatcher("/lastPage.jsp").forward(req, resp);
>>>>>>> 1dcdf7afd77cdb088e934b37030d487cbaf186b1
>>>>>>> 5ad1e92158730f17c1fcf1906a345566a48ed95c
		dbHandler.closeDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}