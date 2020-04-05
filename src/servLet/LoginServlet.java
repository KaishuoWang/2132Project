package servLet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBHandler;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String idString = req.getParameter("id");
		int id = Integer.parseInt(idString);
		DBHandler dbHandler = new DBHandler();
		
		if(role.equals("employee")) {
			dbHandler.findEmployee(id);
		}else if (role.equals("guest")){
			dbHandler.findGuest(id);
		}else if (role.equals("host")) {
			dbHandler.findHost(id);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
