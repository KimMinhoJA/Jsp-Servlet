package ex0416.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0416.dao.MemberDAO;
import ex0416.dao.MemberDAOImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO memberDao = new MemberDAOImpl();
		String url = "error.jsp";
		System.out.println(request.getParameter("id"));
		try {
			memberDao.delete(request.getParameter("id"));
			url = "index.html";
		}catch (SQLException e) {
			request.setAttribute("errMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	

}
