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
		Payment payment = new Payment(Integer.parseInt(req.getParameter("paymentID")),Integer.parseInt(req.getParameter("hostID")),req.getParameter("paymentType"),Float.parseFloat(req.getParameter("amount")), req.getParameter("status"));
		dbHandler.insertePayment(payment);
		dbHandler.closeDB();
		req.getRequestDispatcher("/lastPage.jsp").forward(req, resp);
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}