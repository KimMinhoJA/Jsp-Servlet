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

@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//parameter정보 받기 -> service -> dao
		//오늘은 mvc구조 생각 안하고 바로 dao호출할거다
		String url = "error.jsp";
		MemberDAO memberDao = new MemberDAOImpl();
		try{
			List<Member> list = memberDao.selectAll();
			request.setAttribute("list", list);
			url = "memberSelect.jsp";
		}catch (SQLException e) {
			//예외페이지 이동.
			request.setAttribute("errMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
