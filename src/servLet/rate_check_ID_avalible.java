package servLet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Property;
import classes.Review;
import dao.DBHandler;

@WebServlet(urlPatterns = "/checkIDAva")
public class rate_check_ID_avalible extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBHandler dbHandler = new DBHandler();
		if(!dbHandler.findProperty(Integer.parseInt(req.getParameter("propertyID")))){
			resp.sendRedirect("failedRate.html");
		}
		if(!dbHandler.findGuest(Integer.parseInt(req.getParameter("nameID")))) {
			resp.sendRedirect("failedRate.html");
		}
		Review review = new Review(Integer.parseInt(req.getParameter("reviewID")),Integer.parseInt(req.getParameter("propertyID")));
		review.setRating(Integer.parseInt(req.getParameter("rate")));
		review.setCleanliness(req.getParameter("cleanliness"));
		review.setValue(req.getParameter("value"));
		dbHandler.inserteReview(review);
		dbHandler.closeDB();
		resp.sendRedirect("success.html");
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
}