package servLet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBHandler;

@WebServlet(urlPatterns = "/editPropertyA&R")
public class editPropertyServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBHandler dbHandler = new DBHandler();
		
		
		if(dbHandler.findProperty(Integer.parseInt(req.getParameter("propertyIDEdit")))){
			resp.sendRedirect("success.html");
			if(!req.getParameter("amenitiesEdit").equals("")) {
				dbHandler.updatePropertyString(Integer.parseInt(req.getParameter("propertyIDEdit")), "amenities", req.getParameter("amenitiesEdit"));
			}
			if(!req.getParameter("rulesEdit").equals("")) {
				dbHandler.updatePropertyString(Integer.parseInt(req.getParameter("propertyIDEdit")), "rules", req.getParameter("rulesEdit"));
			}
			if(!req.getParameter("availableDateEdit").equals("")) {
				dbHandler.updateAvailableDate(Integer.parseInt(req.getParameter("propertyIDEdit")), Date.valueOf(req.getParameter("availableDateEdit")));
			}
		}else {
			resp.sendRedirect("DEPropertyFailed.html");
		}
		dbHandler.closeDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
