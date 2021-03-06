package ex0414.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpLoadList")
public class UpLoadListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File(request.getServletContext().getRealPath("/save"));
		if(file.exists()) {
			String list[] = file.list();
			request.setAttribute("fileList", list);
		}
		request.getRequestDispatcher("downloadList.jsp").forward(request, response);
	}

}
