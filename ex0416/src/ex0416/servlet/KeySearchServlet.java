package ex0416.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0416.dao.MemberDAO;
import ex0416.dao.MemberDAOImpl;
import ex0416.domain.Member;

/**
 * Servlet implementation class KeySearchServlet
 */
@WebServlet("/keySearch")
public class KeySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyWord");
		String keyField = request.getParameter("keyField");

		MemberDAO memberDao = new MemberDAOImpl();
		String url = "error.jsp";
		List<Member> list = new ArrayList<Member>();
		try {
			list = memberDao.searchByKeyword(keyField, keyword);
			request.setAttribute("list", list);
			url = "memberSelect.jsp";
		}catch (SQLException e) {
			request.setAttribute("errMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
