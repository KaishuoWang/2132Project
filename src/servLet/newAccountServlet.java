package servLet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBHandler;

@WebServlet(urlPatterns = "/newAccount")
public class newAccountServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String role = req.getParameter("newRole");
		if(role.equals("employee")) {
			req.getRequestDispatcher("/newEmployee.jsp").forward(req, resp);
		}else if (role.equals("guest")){
			req.getRequestDispatcher("/newGuest.jsp").forward(req, resp);
		}else if (role.equals("host")) {
			req.getRequestDispatcher("/newHost.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
