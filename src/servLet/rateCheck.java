package servLet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBHandler;

<<<<<<< HEAD:src/servLet/rateCheck.java
@WebServlet(urlPatterns = "/review")
public class rateCheck extends HttpServlet{

=======
@WebServlet(urlPatterns = "/rate")
public class rateServlet extends HttpServlet{
>>>>>>> parent of b84e9da... review:src/servLet/rateServlet.java
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBHandler dbHandler = new DBHandler();
		req.getRequestDispatcher("/bookSuccess.jsp").forward(req, resp);
		dbHandler.closeDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO auto-generated method stub
		super.doGet(req, resp);
	}

}
