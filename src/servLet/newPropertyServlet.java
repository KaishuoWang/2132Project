package servLet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Property;
import dao.DBHandler;

@WebServlet(urlPatterns = "/createProperty")
public class newPropertyServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBHandler dbHandler = new DBHandler();
		
		if(dbHandler.findProperty(Integer.parseInt(req.getParameter("propertyID")))){
			resp.sendRedirect("newPropertyFailed.html");
		}else {
			resp.sendRedirect("success.html");
			Property property = new Property(Integer.parseInt(req.getParameter("propertyID")), Integer.parseInt(req.getParameter("ownerID")), Integer.parseInt(req.getParameter("houseNum")), req.getParameter("street"), req.getParameter("city"), req.getParameter("province"), req.getParameter("country"), req.getParameter("roomType"), Float.parseFloat(req.getParameter("price")), req.getParameter("class"));
			property.setAvailableDate(Date.valueOf(req.getParameter("availableDate")));
			property.setPropertyType(req.getParameter("propertyType"));
			property.setNumGuest(Integer.parseInt(req.getParameter("guestNum")));
			if(!req.getParameter("amenities").equals("")) {
				property.setAmenities(req.getParameter("amenities"));
			}
			if(!req.getParameter("rules").equals("")) {
				property.setRules(req.getParameter("rules"));
			}
			dbHandler.inserteProperty(property);
		}
		dbHandler.closeDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
