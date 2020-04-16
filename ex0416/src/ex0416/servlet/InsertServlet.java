package ex0416.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO memberDao = new MemberDAOImpl();
		String url = "error.jsp";
		Member member = new Member(request.getParameter("id"), request.getParameter("pwd"), request.getParameter("name"), Integer.parseInt(request.getParameter("age")), request.getParameter("phone"), request.getParameter("addr"));
		try {
			if(!memberDao.idCheck(member.getId())) {
				memberDao.insert(member);
				url = "index.html";
			}else {
				request.setAttribute("errMsg", "아이디 중복");
			}
		}catch (SQLException e) {
			request.setAttribute("errMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
