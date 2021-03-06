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

@WebServlet(urlPatterns = "/submit")
public class bookSuccess extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBHandler dbHandler = new DBHandler();
		if(dbHandler.getPropertyStatement(Integer.parseInt(req.getParameter("id")))){
			dbHandler.updateAvailable(Integer.parseInt(req.getParameter("id")), false);
			dbHandler.updatePropertyInt(Integer.parseInt(req.getParameter("id")), "guestid", Integer.parseInt(req.getParameter("guestID")));
			req.getRequestDispatcher("/bookSuccess.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("alreadyBooked.html");
		}
		dbHandler.closeDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}