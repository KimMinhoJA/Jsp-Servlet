package ex0409.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	String id = "jang";
	String pwd = "1234";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("doPost");
		
		//�Ѿ���� 3���� ������ ȭ�鿡 ���
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>������</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>");
		if(id.equals(userId) && pwd.equals(userPwd)) {
			//service --> dao���� DB�� �����͸� �����ͼ� �������� ����.
			List<String> list = new ArrayList<String>();
			list.add("���");
			list.add("����");
			list.add("����");
			list.add("����");
			request.setAttribute("list", list);

			request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
//			response.sendRedirect("LoginOk.jsp?userName="+URLEncoder.encode(userName, "UTF-8"));
		}else {
			out.println("<script>");
			out.println("alert('" + userName + "�� ������ Ȯ�����ּ���.');");
			out.println("history.back();");
			out.println("</script>");
		}
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
