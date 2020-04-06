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
		boolean found = false;
		
		if(role.equals("employee")) {
			found = dbHandler.findEmployee(id);
			if(found) {
				req.setAttribute("name", dbHandler.getEmployee(id).getfName() + dbHandler.getEmployee(id).getlName());
				req.getRequestDispatcher("/loginSuccessEmployee.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
			}
		}else if (role.equals("guest")){
			found = dbHandler.findGuest(id);
			if(found) {
				req.getRequestDispatcher("/loginSuccessGuest.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
			}
		}else if (role.equals("host")) {
			found = dbHandler.findHost(id);
			if(found) {
				req.getRequestDispatcher("/loginSuccessHost.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
			}
		}
		dbHandler.closeDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
