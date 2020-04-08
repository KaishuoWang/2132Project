package servLet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBHandler;

@WebServlet(urlPatterns = "/review")
<<<<<<< HEAD:src/servLet/rateCheck.java
public class rateCheck extends HttpServlet{
	
=======
public class rateServlet extends HttpServlet{
>>>>>>> b84e9daaaa611645847fef1b226211f182bdbbca:src/servLet/rateServlet.java
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBHandler dbHandler = new DBHandler();
		System.out.println("===============");
		req.getRequestDispatcher("/bookSuccess.jsp").forward(req, resp);
		dbHandler.closeDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO auto-generated method stub
		super.doGet(req, resp);
	}

}
